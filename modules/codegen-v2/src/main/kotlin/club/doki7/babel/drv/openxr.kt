package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateBitmask
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateEnumeration
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.openxr.OpenXRRegistryExt
import club.doki7.babel.extract.openxr.extractOpenXRRegistry
import club.doki7.babel.extract.vulkan.VulkanRegistryExt
import club.doki7.babel.extract.vulkan.extractVulkanRegistry
import club.doki7.babel.extract.vulkanAdditionalRegistry
import club.doki7.sennaar.registry.Bitmask
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.registry.IMergeable
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.babel.util.Doc
import club.doki7.babel.util.render
import club.doki7.babel.util.setupLog
import java.io.File

private const val packageDir = "openxr/src/main/java/club/doki7/openxr"

fun main() {
    setupLog()

    val vulkan = extractVulkanRegistry()
    val vulkanPlus = vulkanAdditionalRegistry()
    openxrMain(vulkan, vulkanPlus, false)
}

private fun openxrMain(
    vulkanRegistry: Registry<VulkanRegistryExt>,
    vulkanAdditionRegistry: Registry,
    dryRun: Boolean
): Registry<OpenXRRegistryExt> {
    val reg = extractOpenXRRegistry()

    val opt = CodegenOptions(
        packageName = "club.doki7.openxr",
        extraImport = listOf(
            "club.doki7.vulkan.bitmask.*",
            "club.doki7.vulkan.datatype.*",
            "club.doki7.vulkan.enumtype.*",
            "club.doki7.vulkan.handle.*",
        ),
        constantClassName = "XRConstants",
        functionTypeClassName = "XRFunctionTypes",
        refRegistries = listOf(vulkanRegistry, vulkanAdditionRegistry),
        seeLinkProvider = ::openxrLinkProvider
    )

    // The following are set:
    // aliases
    // bitmasks
    // constants
    // commands
    // enumerations
    // functionTypedefs
    // opaqueHandleTypedefs
    // structures

    val context = CodegenContext(packageDir, reg, opt, dryRun)

    with(context) {
        generateConstants()
        generateFunctionTypes()
        generateBitmasks()
        generateEnumerations()
        generateStructures()
        generateOpaqueHandles()
        generateCommands()
    }

    return reg
}

// OpenXR does not have the latest version, use version 1.1 as the latest.
// this may need to be updated in the future if OpenXR updates their spec.
private fun openxrLinkProvider(e: Entity): String? = when (e) {
    is Command, is Structure, is Bitmask, is Enumeration, is OpaqueHandleTypedef -> {
        val name = e.name.original
        "<a href=\"https://registry.khronos.org/OpenXR/specs/1.1/man/html/$name.html\"><code>$name</code></a>"
    }
    else -> null
}

/**
 * @param dryRun for testing, only generate code, no writing
 */
private data class CodegenContext<T : IMergeable<T>>(
    val packageDir: String,
    val registry: Registry<T>,
    val codegenOptions: CodegenOptions,
    val dryRun: Boolean,
) {
    private fun file(path: String): File {
        return File("$packageDir/$path")
    }

    private fun Doc.writeTo(relativePath: String) {
        if (!dryRun) {
            file(relativePath).apply {
                parentFile.mkdirs()
            }.writeText(render(this))
        }
    }

    fun generateConstants() {
        generateConstants(registry, codegenOptions)
            .writeTo("${codegenOptions.constantClassName}.java")
    }

    fun generateFunctionTypes() {
        generateFunctionTypedefs(registry, codegenOptions).writeTo("${codegenOptions.functionTypeClassName}.java")
    }

    fun generateBitmask(bitmask: Bitmask) {
        generateBitmask(bitmask, codegenOptions).writeTo("bitmask/${bitmask.name}.java")
    }

    fun generateBitmasks() {
        registry.bitmasks.values.forEach(::generateBitmask)
    }

    fun generateEnumeration(enumeration: Enumeration) {
        generateEnumeration(registry, enumeration, codegenOptions).writeTo("enumtype/${enumeration.name}.java")
    }

    fun generateEnumerations() {
        registry.enumerations.values.forEach(::generateEnumeration)
    }

    fun generateStructure(structure: Structure) {
        generateStructureInterface(structure, codegenOptions)
            .writeTo("datatype/I${structure.name}.java")

        generateStructure(registry, structure, false, codegenOptions)
            .writeTo("datatype/${structure.name}.java")
    }

    fun generateStructures() {
        registry.structs.values.forEach(::generateStructure)
    }

    fun generateOpaqueHandle(handle: OpaqueHandleTypedef) {
        generateHandle(handle, codegenOptions)
            .writeTo("handle/${handle.name}.java")
    }

    fun generateOpaqueHandles() {
        registry.opaqueHandleTypedefs.values.forEach(::generateOpaqueHandle)
    }

    fun generateCommands() {
        val staticCommands = registry.commands.values
            .filter { it -> staticCommands.contains(it.name.original) }
            .sortedBy { it.name.original }
            .toList()
        generateCommandFile(
            registry,
            "XRStatic",
            staticCommands,
            codegenOptions,
            true,
            "command"
        ).writeTo("command/XRStatic.java")
        generateCommandFile(
            registry,
            "XR",
            registry.commands.values.sortedBy { it.name.original }.toList(),
            codegenOptions,
            true,
            "command"
        ).writeTo("command/XR.java")
    }
}

private val staticCommands = setOf(
    "xrAcquireSwapchainImage",
    "xrApplyHapticFeedback",
    "xrAttachSessionActionSets",
    "xrBeginFrame",
    "xrBeginSession",
    "xrCreateAction",
    "xrCreateActionSet",
    "xrCreateActionSpace",
    "xrCreateInstance",
    "xrCreateReferenceSpace",
    "xrCreateSession",
    "xrCreateSwapchain",
    "xrDestroyAction",
    "xrDestroyActionSet",
    "xrDestroyInstance",
    "xrDestroySession",
    "xrDestroySpace",
    "xrDestroySwapchain",
    "xrEndFrame",
    "xrEndSession",
    "xrEnumerateApiLayerProperties",
    "xrEnumerateBoundSourcesForAction",
    "xrEnumerateEnvironmentBlendModes",
    "xrEnumerateInstanceExtensionProperties",
    "xrEnumerateReferenceSpaces",
    "xrEnumerateSwapchainFormats",
    "xrEnumerateSwapchainImages",
    "xrEnumerateViewConfigurations",
    "xrEnumerateViewConfigurationViews",
    "xrGetActionStateBoolean",
    "xrGetActionStateFloat",
    "xrGetActionStatePose",
    "xrGetActionStateVector2f",
    "xrGetCurrentInteractionProfile",
    "xrGetInputSourceLocalizedName",
    "xrGetInstanceProcAddr",
    "xrGetInstanceProperties",
    "xrGetReferenceSpaceBoundsRect",
    "xrGetSystem",
    "xrGetSystemProperties",
    "xrGetViewConfigurationProperties",
    "xrLocateSpace",
    "xrLocateViews",
    "xrPathToString",
    "xrPollEvent",
    "xrReleaseSwapchainImage",
    "xrRequestExitSession",
    "xrResultToString",
    "xrStopHapticFeedback",
    "xrStringToPath",
    "xrStructureTypeToString",
    "xrSuggestInteractionProfileBindings",
    "xrSyncActions",
    "xrWaitFrame",
    "xrWaitSwapchainImage"
)

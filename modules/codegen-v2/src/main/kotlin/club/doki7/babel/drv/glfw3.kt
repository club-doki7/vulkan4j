package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.glfw3.extractGLFWHeader
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.render
import java.io.File

private const val packageDir = "glfw/src/main/java/club/doki7/glfw"

fun glfw3Main(vulkanRegistry: Registry, vulkanAdditionalRegistry: Registry) {
    val registry = extractGLFWHeader()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.glfw",
        extraImport = listOf(),
        constantClassName = "GLFWConstants",
        functionTypeClassName = "GLFWFunctionTypes",
        refRegistries = listOf(vulkanRegistry, vulkanAdditionalRegistry)
    )

    val constantsDoc = generateConstants(registry, codegenOptions)
    File("$packageDir/${codegenOptions.constantClassName}.java")
        .writeText(render(constantsDoc))

    val commandCodegenOptions = codegenOptions.copy(
        extraImport = listOf(
            "club.doki7.vulkan.datatype.*",
            "club.doki7.vulkan.enumtype.*",
            "club.doki7.vulkan.handle.*"
        )
    )
    val commandsDoc = generateCommandFile(
        registry,
        "GLFW",
        registry.commands.values.sortedBy { it.name },
        commandCodegenOptions,
        implConstantClass = true,
        subpackage = null
    )
    File("$packageDir/GLFW.java")
        .writeText(render(commandsDoc))

    for (structure in registry.structs.values) {
        val structureInterfaceDoc = generateStructureInterface(structure, codegenOptions)
        File("$packageDir/datatype/I${structure.name}.java")
            .writeText(render(structureInterfaceDoc))

        val structureDoc = generateStructure(registry, structure, false, codegenOptions)
        File("$packageDir/datatype/${structure.name}.java")
            .writeText(render(structureDoc))
    }

    for (opaqueTypedef in registry.opaqueTypedefs.values) {
        val handleTypedef = OpaqueHandleTypedef(opaqueTypedef.name)
        handleTypedef.doc = opaqueTypedef.doc
        val handleDoc = generateHandle(handleTypedef, codegenOptions)
        File("$packageDir/handle/${opaqueTypedef.name}.java")
            .writeText(render(handleDoc))
    }

    val functionTypedefDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java")
        .writeText(render(functionTypedefDoc))
}

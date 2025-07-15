package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.opencl.OpenCLRegistryExt
import club.doki7.babel.extract.opencl.extractOpenCLRegistry
import club.doki7.babel.registry.Command
import club.doki7.babel.registry.Constant
import club.doki7.babel.registry.Entity
import club.doki7.babel.registry.IMergeable
import club.doki7.babel.registry.OpaqueHandleTypedef
import club.doki7.babel.registry.OpaqueTypedef
import club.doki7.babel.registry.Registry
import club.doki7.babel.registry.Structure
import club.doki7.babel.util.Doc
import club.doki7.babel.util.render
import java.io.File

private const val packageDir = "opencl/src/main/java/club/doki7/opencl"

fun main() {
    openclMain(false)
}

fun openclMain(dryRun: Boolean): Registry<OpenCLRegistryExt> {
    val reg = extractOpenCLRegistry()
    val opt = CodegenOptions(
        "club.doki7.opencl",
        emptyList(),
        "CLConstants",
        "CLFunctionTypes",
        emptyList(),
        ::openclLinkProvider
    )

    val context = ClCodegenContext(packageDir, reg, opt, "CL", dryRun)
    with(context) {
        generateConstants()
        generateFunctionTypes()
        generateStructures()
        generateUnions()
        generateOpaqueHandles()
        generateOpaqueTypedefs()
        generateCommands()
    }

    return reg
}

private fun openclLinkProvider(e: Entity): String? = when (e) {
    is Command, is Structure, is OpaqueHandleTypedef, is OpaqueTypedef -> {
        if (e.name.original.startsWith("VA")) {
            null
        } else {
            val name = e.name.original
            val url = "https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/$name.html"
            "<a href=\"$url\">$name</a>"
        }
    }

    else -> null
}

/**
 * @param dryRun for testing, only generate code, no writing
 */
private data class ClCodegenContext<T : IMergeable<T>>(
    val packageDir: String,
    val registry: Registry<T>,
    val codegenOptions: CodegenOptions,
    val commandFileName: String,
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

    fun generateStructure(structure: Structure, isUnion: Boolean) {
        generateStructureInterface(structure, codegenOptions)
            .writeTo("datatype/I${structure.name}.java")

        generateStructure(registry, structure, isUnion, codegenOptions)
            .writeTo("datatype/${structure.name}.java")
    }

    fun generateStructures() {
        registry.structures.values.forEach { generateStructure(it, false) }
    }

    fun generateUnions() {
        registry.unions.values.forEach { generateStructure(it, true) }
    }

    fun generateOpaqueHandle(handle: OpaqueHandleTypedef) {
        generateHandle(handle, codegenOptions)
            .writeTo("handle/${handle.name}.java")
    }

    fun generateOpaqueHandles() {
        registry.opaqueHandleTypedefs.values.forEach(::generateOpaqueHandle)
    }

    fun generateOpaqueTypedefs() {
        registry.opaqueTypedefs.values
            .asSequence()
            .filter { it.isHandle }
            .map { OpaqueHandleTypedef(it.name) }
            .forEach(::generateOpaqueHandle)
    }

    fun generateCommands() {
        generateCommandFile(
            registry,
            commandFileName,
            registry.commands.values.toList(),
            codegenOptions,
            true,
            null
        ).writeTo("$commandFileName.java")
    }
}

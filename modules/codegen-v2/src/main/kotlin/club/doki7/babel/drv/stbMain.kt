package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateConstants
import club.doki7.babel.codegen.generateEnumeration
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.stb.extractSTBImageHeader
import club.doki7.babel.extract.stb.extractSTBImageResizeHeader
import club.doki7.babel.extract.stb.extractSTBImageWriteHeader
import club.doki7.babel.extract.stb.extractSTBTrueTypeHeader
import club.doki7.babel.extract.stb.extractSTBVorbisHeader
import club.doki7.babel.registry.EmptyMergeable
import club.doki7.babel.registry.OpaqueHandleTypedef
import club.doki7.babel.registry.Registry
import club.doki7.babel.util.render
import club.doki7.babel.util.setupLog
import java.io.File

fun main() {
    setupLog()

    val stbImageRegistry = extractSTBImageHeader()
    val stbTrueTypeRegistry = extractSTBTrueTypeHeader()
    val stbImageResizeRegistry = extractSTBImageResizeHeader()
    val stbImageWriteRegistry = extractSTBImageWriteHeader()
    val stbVorbisRegistry = extractSTBVorbisHeader()

    val stbImageCodegenOptions = CodegenOptions(
        packageName = "club.doki7.stb.image",
        extraImport = listOf(),
        constantClassName = "STBImageConstants",
        functionTypeClassName = "STBIFunctionTypes",
        refRegistries = listOf()
    )
    val stbTrueTypeCodegenOptions = CodegenOptions(
        packageName = "club.doki7.stb.truetype",
        extraImport = listOf(),
        constantClassName = "STBTrueTypeConstants",
        functionTypeClassName = "STBTTFunctionTypes",
        refRegistries = listOf()
    )
    val stbImageResizeCodegenOptions = CodegenOptions(
        packageName = "club.doki7.stb.imageresize",
        extraImport = listOf(),
        constantClassName = "STBImageResizeConstants",
        functionTypeClassName = "STBIRFunctionTypes",
        refRegistries = listOf()
    )
    val stbImageWriteCodegenOptions = CodegenOptions(
        packageName = "club.doki7.stb.imagewrite",
        extraImport = listOf(),
        constantClassName = "STBImageWriteConstants",
        functionTypeClassName = "STBIWFunctionTypes",
        refRegistries = listOf()
    )
    val stbVorbisCodegenOptions = CodegenOptions(
        packageName = "club.doki7.stb.vorbis",
        extraImport = listOf(),
        constantClassName = "STBVorbisConstants",
        functionTypeClassName = "STBVorbisFunctionTypes",
        refRegistries = listOf()
    )

    codegen("stb/src/main/java/club/doki7/stb/image", "STBI", stbImageRegistry, stbImageCodegenOptions)
    codegen("stb/src/main/java/club/doki7/stb/truetype", "STBTT", stbTrueTypeRegistry, stbTrueTypeCodegenOptions)
    codegen("stb/src/main/java/club/doki7/stb/imageresize", "STBIR", stbImageResizeRegistry, stbImageResizeCodegenOptions)
    codegen("stb/src/main/java/club/doki7/stb/imagewrite", "STBIW", stbImageWriteRegistry, stbImageWriteCodegenOptions)
    codegen("stb/src/main/java/club/doki7/stb/vorbis", "STBVorbis", stbVorbisRegistry, stbVorbisCodegenOptions)
}

private fun codegen(
    packageDir: String,
    commandClassName: String,
    registry: Registry<EmptyMergeable>,
    codegenOptions: CodegenOptions
) {
    val commandsDoc = generateCommandFile(
        registry,
        commandClassName,
        registry.commands.values
            .filter { it -> !it.params.any { param -> param.type.cDisplay.contains("FILE*") } }
            .sortedBy { it.name },
        codegenOptions,
        implConstantClass = false,
        subpackage = null
    )
    File("$packageDir/$commandClassName.java").writeText(render(commandsDoc))

    val functionTypedefsDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java").writeText(render(functionTypedefsDoc))

    val constantsDoc = generateConstants(registry, codegenOptions)
    File("$packageDir/${codegenOptions.constantClassName}.java").writeText(render(constantsDoc))

    if (registry.enumerations.isNotEmpty()) {
        for (enum in registry.enumerations.values) {
            val enumDoc = generateEnumeration(registry, enum, codegenOptions)
            File("$packageDir/enumtype/${enum.name}.java").writeText(render(enumDoc))
        }
    }

    if (registry.structures.isNotEmpty()) {
        for (structure in registry.structures.values) {
            val structureInterfaceDoc = generateStructureInterface(structure, codegenOptions)
            File("$packageDir/datatype/I${structure.name}.java").writeText(render(structureInterfaceDoc))

            val structureDoc = generateStructure(registry, structure, false, codegenOptions)
            File("$packageDir/datatype/${structure.name}.java").writeText(render(structureDoc))
        }
    }

    if (registry.opaqueTypedefs.isNotEmpty()) {
        for (opaqueTypedef in registry.opaqueTypedefs.values) {
            val handle = OpaqueHandleTypedef(opaqueTypedef.name)
            val handleDoc = generateHandle(handle, codegenOptions)
            File("$packageDir/handle/${handle.name}.java").writeText(render(handleDoc))
        }
    }
}

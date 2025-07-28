package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateEnumeration
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.shaderc.extractShadercRegistry
import club.doki7.babel.util.render
import club.doki7.babel.util.setupLog
import java.io.File

private const val packageDir = "shaderc/src/main/java/club/doki7/shaderc"

fun main() {
    setupLog()

    val registry = extractShadercRegistry()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.shaderc",
        extraImport = listOf(),
        constantClassName = "ShadercConstants",
        functionTypeClassName = "ShadercFunctionTypes",
        refRegistries = emptyList(),
    )

    val commandsDoc = generateCommandFile(
        registry,
        "Shaderc",
        registry.commands.values.sortedBy { it.name },
        codegenOptions,
        implConstantClass = false,
        subpackage = null
    )
    File("$packageDir/Shaderc.java").writeText(render(commandsDoc))

    val functionTypedefsDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java").writeText(render(functionTypedefsDoc))

    for (enum in registry.enumerations.values) {
        val enumDoc = generateEnumeration(registry, enum, codegenOptions)
        File("$packageDir/enumtype/${enum.name}.java").writeText(render(enumDoc))
    }

    for (structure in registry.structs.values) {
        val structureInterfaceDoc = generateStructureInterface(structure, codegenOptions)
        File("$packageDir/datatype/I${structure.name}.java").writeText(render(structureInterfaceDoc))

        val structureDoc = generateStructure(registry, structure, false, codegenOptions)
        File("$packageDir/datatype/${structure.name}.java").writeText(render(structureDoc))
    }

    for (handle in registry.opaqueHandleTypedefs.values) {
        val handleDoc = generateHandle(handle, codegenOptions)
        File("$packageDir/handle/${handle.name}.java").writeText(render(handleDoc))
    }
}

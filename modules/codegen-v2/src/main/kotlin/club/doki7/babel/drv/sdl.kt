package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateBitmask
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateEnumeration
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.sdl3.extractSDLRegistry
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.babel.util.render
import club.doki7.babel.util.setupLog
import java.io.File

private const val packageDir = "sdl3/src/main/java/club/doki7/sdl3"

fun main() {
    setupLog()

    val registry = extractSDLRegistry()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.sdl3",
        extraImport = listOf(),
        constantClassName = "SDL3Constants",
        functionTypeClassName = "SDL3FunctionTypes",
        refRegistries = emptyList()
    )

//    val constantsDoc = generateConstants(registry, codegenOptions)
//    File("$packageDir/${codegenOptions.constantClassName}.java")
//        .writeText(render(constantsDoc))

    val functionTypeDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java")
        .writeText(render(functionTypeDoc))

    for (structure in registry.structs.values) {
        val structureInterfaceDoc = generateStructureInterface(structure, codegenOptions)
        File("$packageDir/datatype/I${structure.name}.java")
            .writeText(render(structureInterfaceDoc))

        val structureDoc = generateStructure(registry, structure, false, codegenOptions)
        File("$packageDir/datatype/${structure.name}.java")
            .writeText(render(structureDoc))
    }

    for (union in registry.unions.values) {
        val structureInterfaceDoc = generateStructureInterface(union, codegenOptions)
        File("$packageDir/datatype/I${union.name}.java")
            .writeText(render(structureInterfaceDoc))

        val structureDoc = generateStructure(registry, union, true, codegenOptions)
        File("$packageDir/datatype/${union.name}.java")
            .writeText(render(structureDoc))
    }

    for (bitmask in registry.bitmasks.values) {
        val bitmaskDoc = generateBitmask(bitmask, codegenOptions)
        File("$packageDir/bitmask/${bitmask.name}.java")
            .writeText(render(bitmaskDoc))
    }

    for (enumeration in registry.enumerations.values) {
        val enumerationDoc = generateEnumeration(registry, enumeration, codegenOptions)
        File("$packageDir/enumtype/${enumeration.name}.java")
            .writeText(render(enumerationDoc))
    }

    for (opaqueTypedef in registry.opaqueTypedefs.values) {
        if (opaqueTypedef.isHandle) {
            val handle = OpaqueHandleTypedef(opaqueTypedef.name)
            val handleDoc = generateHandle(handle, codegenOptions)
            File("$packageDir/handle/${handle.name}.java")
                .writeText(render(handleDoc))
        }
    }

    for (opaqueHandleTypedef in registry.opaqueHandleTypedefs.values) {
        val handleDoc = generateHandle(opaqueHandleTypedef, codegenOptions)
        File("$packageDir/handle/${opaqueHandleTypedef.name}.java")
            .writeText(render(handleDoc))
    }

    val toGenerateCommands = registry.commands.values
        .filter {
            !it.params.any { param ->
                param.name.original == "..."
                        || (param.type is IdentifierType && (param.type as IdentifierType).ident.original == "va_list")
            }
        }
        .toList()

    val commandDoc = generateCommandFile(
        registry,
        "SDL3",
        toGenerateCommands,
        codegenOptions,
        implConstantClass = true,
        subpackage = null
    )
    File("$packageDir/SDL3.java")
        .writeText(render(commandDoc))
}

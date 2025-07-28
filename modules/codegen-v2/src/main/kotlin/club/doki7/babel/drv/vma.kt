package club.doki7.babel.drv

import club.doki7.babel.codegen.CodegenOptions
import club.doki7.babel.codegen.generateBitmask
import club.doki7.babel.codegen.generateCommandFile
import club.doki7.babel.codegen.generateEnumeration
import club.doki7.babel.codegen.generateFunctionTypedefs
import club.doki7.babel.codegen.generateHandle
import club.doki7.babel.codegen.generateStructure
import club.doki7.babel.codegen.generateStructureInterface
import club.doki7.babel.extract.vma.extractVMAHeader
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import club.doki7.babel.util.Either
import club.doki7.babel.util.render
import java.io.File

private const val packageDir = "vma/src/main/java/club/doki7/vma"

fun vmaMain(vulkanRegistry: Registry, vulkanAdditionalRegistry: Registry) {
    val registry = extractVMAHeader()

    val codegenOptions = CodegenOptions(
        packageName = "club.doki7.vma",
        extraImport = listOf(
            "club.doki7.vulkan.bitmask.*",
            "club.doki7.vulkan.datatype.*",
            "club.doki7.vulkan.enumtype.*",
            "club.doki7.vulkan.handle.*"
        ),
        constantClassName = "VMAConstants",
        functionTypeClassName = "VMAFunctionTypes",
        refRegistries = listOf(vulkanRegistry, vulkanAdditionalRegistry),
    )

    val functionTypeDoc = generateFunctionTypedefs(registry, codegenOptions)
    File("$packageDir/${codegenOptions.functionTypeClassName}.java")
        .writeText(render(functionTypeDoc))

    val bitmaskAndEnumCodegenOptions = codegenOptions.copy(extraImport = emptyList())
    for (bitmask in registry.bitmasks.values) {
        if (bitmask.name.original == "VmaVirtualAllocationCreateFlags") {
            continue
        }

        val bitmaskDoc = generateBitmask(bitmask, bitmaskAndEnumCodegenOptions)
        File("$packageDir/bitmask/${bitmask.name}.java")
            .writeText(render(bitmaskDoc))
    }

    do {
        val bitmask = registry.bitmasks["VmaVirtualAllocationCreateFlags".interned()]!!
        bitmask.bitflags.forEach {
            if (it.value is Either.Right) {
                for ((idx, value) in it.value.value.withIndex()) {
                    it.value.value[idx] = "VmaAllocationCreateFlags." +
                            value.removePrefix("VMA_ALLOCATION_CREATE_")
                }
            }
        }
        val bitmaskDoc = generateBitmask(bitmask, bitmaskAndEnumCodegenOptions)
        File("$packageDir/bitmask/VmaVirtualAllocationCreateFlags.java")
            .writeText(render(bitmaskDoc))
    } while (false)

    for (enumeration in registry.enumerations.values) {
        val enumerationDoc = generateEnumeration(registry, enumeration, bitmaskAndEnumCodegenOptions)
        File("$packageDir/enumtype/${enumeration.name}.java")
            .writeText(render(enumerationDoc))
    }

    val structureCodegenOptions = codegenOptions.copy(
        extraImport = listOf(
            "club.doki7.vulkan.bitmask.*",
            "club.doki7.vulkan.datatype.*",
            "club.doki7.vulkan.enumtype.*",
            "club.doki7.vulkan.handle.*",
            "static club.doki7.vulkan.VkConstants.*"
        )
    )
    for (structure in registry.structs.values) {
        val structureInterfaceDoc = generateStructureInterface(structure, codegenOptions)
        File("$packageDir/datatype/I${structure.name}.java")
            .writeText(render(structureInterfaceDoc))

        val structureDoc = generateStructure(registry, structure, false, structureCodegenOptions)
        File("$packageDir/datatype/${structure.name}.java")
            .writeText(render(structureDoc))
    }

    for (handle in registry.opaqueHandleTypedefs.values) {
        val handleDoc = generateHandle(handle, codegenOptions)
        File("$packageDir/handle/${handle.name}.java")
            .writeText(render(handleDoc))
    }

    val commandFile = generateCommandFile(
        registry,
        "VMA",
        registry.commands.values.toList(),
        codegenOptions,
        implConstantClass = false,
        subpackage = null
    )
    File("$packageDir/VMA.java")
        .writeText(render(commandFile))
}

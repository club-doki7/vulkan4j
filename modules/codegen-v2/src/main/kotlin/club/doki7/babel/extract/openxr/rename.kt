package club.doki7.babel.extract.openxr

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.babel.extract.renameVariantOrBitflag
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import club.doki7.babel.util.Either
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/openxr-renamed-entities.csv"

internal fun Registry<OpenXRRegistryExt>.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    commands.values.forEach {
        it.rename { removePrefix("xr").ensureLowerCamelCase() }
        putEntityIfNameReplaced(it)
    }

    constants.values.forEach {
        it.rename { removePrefix("XR_") }
        putEntityIfNameReplaced(it)
    }

    for (enum in enumerations.values) {
        putEntityIfNameReplaced(enum)
        for (variant in enum.variants) {
            variant.rename { renameVariantOrBitflag(this, enum.name.value) }
            putEntityIfNameReplaced(variant)
        }
    }
    enumerations["XrStructureType".interned()]!!.variants.forEach { variant ->
        variant.rename { removePrefix("XR_TYPE_") }
        putEntityIfNameReplaced(variant)
    }
    enumerations["XrResult".interned()]!!.variants.forEach { variant ->
        variant.rename { removePrefix("XR_") }
        putEntityIfNameReplaced(variant)
    }

    for (enum in enumerations.values) {
        for (index in enum.variants.indices) {
            val variant = enum.variants[index]
            if (variant.value is Either.Right<Long, List<String>>) {
                val variantValue = (variant.value as Either.Right<Long, List<String>>).value
                if (variantValue.size == 1) {
                    enum.variants[index] = EnumVariant(
                        name = variant.name,
                        value = Either.Right(listOf(variantValue.first().interned().value))
                    )
                }
            }
        }
    }

    for (bitmask in bitmasks.values) {
        putEntityIfNameReplaced(bitmask)
        for (bitflag in bitmask.bitflags) {
            bitflag.rename { renameVariantOrBitflag(this, bitmask.name.value, true) }
            putEntityIfNameReplaced(bitflag)
        }
    }

    log.info(" - 重命名完成，重命名了 ${renamed.size} 个项目，完整列表可参见 $renamedEntitiesFile")
    File(renamedEntitiesFile).writeText(buildString {
        appendLine("original,new")
        for ((original, renamed) in renamed) {
            appendLine("$original,$renamed")
        }
    })
}

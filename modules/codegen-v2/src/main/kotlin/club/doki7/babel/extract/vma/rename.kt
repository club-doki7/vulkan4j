package club.doki7.babel.extract.vma

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.babel.extract.renameVariantOrBitflag
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.Either
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/vma-renamed-entities.csv"

internal fun Registry.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    constants.forEach { it.value.rename(::renameConstant); putEntityIfNameReplaced(it.value) }
    commands.forEach { it.value.rename(::renameCommand); putEntityIfNameReplaced(it.value) }

    for (enum in enumerations.values) {
        putEntityIfNameReplaced(enum)
        for (value in enum.variants) {
            value.rename { renameVariantOrBitflag(this, enum.name.value) }
            putEntityIfNameReplaced(value)
        }
    }

    for (bitmask in bitmasks.values) {
        putEntityIfNameReplaced(bitmask)
        for (bitflag in bitmask.bitflags) {
            bitflag.rename { renameVariantOrBitflag(this, bitmask.name.value, true) }
            putEntityIfNameReplaced(bitflag)

            if (bitflag.value is Either.Right) {
                for ((idx, value) in bitflag.value.value.withIndex()) {
                    bitflag.value.value[idx] = renameVariantOrBitflag(value, bitmask.name.value, true)
                }
            }
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

private fun renameConstant(name: String) = name.removePrefix("VMA_")

private fun renameCommand(name: String) = name.removePrefix("vma").ensureLowerCamelCase()

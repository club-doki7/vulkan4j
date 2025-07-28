package club.doki7.babel.extract.sdl3

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import club.doki7.babel.util.Either
import club.doki7.babel.util.commonPrefix
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/sdl-renamed-entities.csv"

internal fun Registry.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    constants.forEach { it.value.rename(::renameConstant); putEntityIfNameReplaced(it.value) }
    commands.forEach { it.value.rename(::renameCommand); putEntityIfNameReplaced(it.value) }

    enumerations.values.forEach {
        if (it.variants.size > 1) {
            var commonPrefix = commonPrefix(it.variants.map { variant -> variant.name.value })
            while (commonPrefix.isNotEmpty() && !commonPrefix.endsWith('_')) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length - 1)
            }

            it.variants.forEach { variant ->
                var renamed = variant.name.value.removePrefix(commonPrefix)
                if (renamed[0].isDigit()) {
                    renamed = "_$renamed"
                }
                variant.rename(renamed)
                putEntityIfNameReplaced(variant)
            }
        }
    }

    enumerations.values.forEach {
        it.variants.forEach { variant ->
            if (variant.value is Either.Right) {
                variant.value = Either.Right(
                    (variant.value as Either.Right<Long, List<String>>).value.map { value ->
                        value.interned().value
                    }
                )
            }
        }
    }

    bitmasks.values.forEach {
        if (it.bitflags.size > 1) {
            var commonPrefix = commonPrefix(it.bitflags.map { bitflag -> bitflag.name.value })
            while (commonPrefix.isNotEmpty() && !commonPrefix.endsWith('_')) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length - 1)
            }

            it.bitflags.forEach { bitflag ->
                var renamed = bitflag.name.value.removePrefix(commonPrefix)
                if (renamed[0].isDigit()) {
                    renamed = "_$renamed"
                }
                bitflag.rename(renamed)
                putEntityIfNameReplaced(bitflag)

                if (bitflag.value is Either.Right) {
                    for ((idx, value) in bitflag.value.value.withIndex()) {
                        bitflag.value.value[idx] = value.removePrefix(commonPrefix)
                    }
                }
            }
        }
    }

    "SDL_GLOB_CASEINSENSITIVE".interned().rename("CASEINSENSITIVE")
    renamed.putIfAbsent("SDL_GLOB_CASEINSENSITIVE", "CASEINSENSITIVE")

    log.info(" - 重命名完成，重命名了 ${renamed.size} 个项目，完整列表可参见 $renamedEntitiesFile")
    File(renamedEntitiesFile).writeText(buildString {
        appendLine("original,new")
        for ((original, renamed) in renamed) {
            appendLine("$original,$renamed")
        }
    })
}

private fun renameConstant(name: String) = name.removePrefix("SDL_")

private fun renameCommand(name: String) = name.removePrefix("SDL_").ensureLowerCamelCase()

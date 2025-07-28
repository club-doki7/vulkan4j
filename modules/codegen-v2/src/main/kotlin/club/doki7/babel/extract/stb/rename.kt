package club.doki7.babel.extract.stb

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.commonPrefix
import java.io.File

internal fun Registry.renameEntities(
    component: String,
    prefix: String,
    functionSnakeCase: Boolean
): Registry {
    val renamedEntitiesFile = "codegen-v2/output/stb-${component}-renamed-entities.csv"

    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    fun renameConstant(name: String) = name.removePrefix(prefix.uppercase()).uppercase()
    constants.forEach { it.value.rename(::renameConstant); putEntityIfNameReplaced(it.value) }

    fun renameCommand(name: String) =
        if (functionSnakeCase) renameCommandSnakeCase(prefix, name)
        else renameCommandCamelCase(prefix, name)
    commands.forEach {
        it.value.rename(::renameCommand)
        putEntityIfNameReplaced(it.value)

        it.value.params.forEach { param ->
            param.rename { renameVar(param.name.original) }
            putEntityIfNameReplaced(param)
        }
    }

    for (enum in enumerations.values) {
        enum.rename(::renameTypeNameSnakeCase)
        putEntityIfNameReplaced(enum)

        val commonPrefix = commonPrefix(enum.variants.map { it.name.original })
        for (variant in enum.variants) {
            var renamed = variant.name.original.removePrefix(commonPrefix).uppercase()
            if (renamed[0].isDigit()) {
                renamed = "_$renamed"
            }
            variant.rename(renamed)
            putEntityIfNameReplaced(variant)
        }
    }

    for (structure in structures.values) {
        structure.rename(::renameTypeNameSnakeCase)
        putEntityIfNameReplaced(structure)

        for (member in structure.members) {
            member.rename { renameVar(member.name.original) }
            putEntityIfNameReplaced(member)
        }
    }

    for (opaqueTypedef in opaqueTypedefs.values) {
        opaqueTypedef.rename(::renameTypeNameSnakeCase)
        putEntityIfNameReplaced(opaqueTypedef)
    }

    File(renamedEntitiesFile).writeText(buildString {
        appendLine("original,new")
        for ((original, renamed) in renamed) {
            appendLine("$original,$renamed")
        }
    })
    log.info(" - 重命名完成，重命名了 ${renamed.size} 个项目，完整列表可参见 $renamedEntitiesFile")

    return this
}

fun renameCommandSnakeCase(prefix: String, name: String) = buildString {
    val parts = name.removePrefix(prefix).split('_')
    parts.forEachIndexed { index, part ->
        if (part.isEmpty()) return@forEachIndexed
        if (index == 0) {
            append(part.lowercase())
        } else {
            append(part.replaceFirstChar { it.uppercase() })
        }
    }
}

fun renameCommandCamelCase(prefix: String, name: String) =
    name.removePrefix(prefix).ensureLowerCamelCase()

fun renameTypeNameSnakeCase(name: String) = buildString {
    val parts = name.split('_')
    parts.forEachIndexed { index, part ->
        if (part.isEmpty()) return@forEachIndexed
        if (index == 0) {
            append(part.uppercase())
            append("_")
        } else {
            append(part.replaceFirstChar { it.uppercase() })
        }
    }
}

fun renameVar(name: String) = buildString {
    val parts = name.split('_')
    parts.forEachIndexed { index, part ->
        if (part.isEmpty()) return@forEachIndexed
        if (index == 0) {
            append(part.lowercase())
        } else {
            append(part.replaceFirstChar { it.uppercase() })
        }
    }
}

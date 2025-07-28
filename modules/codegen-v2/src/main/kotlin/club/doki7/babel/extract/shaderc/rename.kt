package club.doki7.babel.extract.shaderc

import club.doki7.babel.extract.vma.log
import club.doki7.sennaar.registry.EmptyMergeable
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.babel.util.commonPrefix
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/shaderc-renamed-entities.csv"

internal fun Registry.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    commands.forEach { it.value.rename(::renameCommand); putEntityIfNameReplaced(it.value) }
    enumerations.forEach { it.value.rename(::renameTypeName); putEntityIfNameReplaced(it.value) }
    structures.forEach { it.value.rename(::renameTypeName); putEntityIfNameReplaced(it.value) }
    opaqueHandleTypedefs.forEach { it.value.rename(::renameHandleTypeName); putEntityIfNameReplaced(it.value) }

    for (enum in enumerations.values) {
        val commonPrefix = if (enum.name.original == "shaderc_spirv_version") {
            "shaderc_spirv_"
        } else {
            commonPrefix(enum.variants.map { it.name.original })
        }
        for (variant in enum.variants) {
            variant.rename(variant.name.original.removePrefix(commonPrefix).uppercase())
            putEntityIfNameReplaced(variant)
        }
    }

    for (structure in structures.values) {
        for (member in structure.members) {
            if (member.name.original != member.name.value) {
                renamed.putIfAbsent(member.name.original, member.name.value)
            }
            member.rename(::renameVar)
            putEntityIfNameReplaced(member)
        }
    }

    for (command in commands.values) {
        for (param in command.params) {
            param.rename(::renameVar)
            putEntityIfNameReplaced(param)
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

private val knownShorthands = setOf(
    "spirv", "spv", "hlsl", "nan"
)

private fun renameCommand(name: String) = buildString {
    val parts = name.removePrefix("shaderc_").splitToSequence("_")
    parts.forEachIndexed { index, part ->
        if (part.isEmpty()) return@forEachIndexed
        if (index == 0) {
            append(part)
            return@forEachIndexed
        }

        if (part in knownShorthands) {
            append(part.uppercase())
        } else {
            append(part.replaceFirstChar { it.uppercase() })
        }
    }
}

private fun renameTypeName(name: String) = buildString {
    val parts = name.splitToSequence("_")
    parts.forEach { part -> append(part.replaceFirstChar { it.uppercase() }) }
}

private fun renameHandleTypeName(name: String) = renameTypeName(name.removeSuffix("_t"))

private fun renameVar(name: String) = buildString {
    val parts = name.splitToSequence("_")
    parts.forEachIndexed { index, part ->
        if (part.isEmpty()) return@forEachIndexed
        if (index == 0) {
            append(part)
            return@forEachIndexed
        }
        append(part.replaceFirstChar { it.uppercase() })
    }
}

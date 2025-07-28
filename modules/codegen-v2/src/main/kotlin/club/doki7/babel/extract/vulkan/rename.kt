package club.doki7.babel.extract.vulkan

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.babel.extract.renameVariantOrBitflag
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/vulkan-renamed-entities.csv"

internal fun Registry.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    commands.forEach { it.value.rename(::renameCommand); putEntityIfNameReplaced(it.value) }
    constants.forEach { it.value.rename(::renameConstant); putEntityIfNameReplaced(it.value) }

    for (enum in enumerations.values) {
        putEntityIfNameReplaced(enum)
        for (value in enum.variants) {
            value.rename { renameVariantOrBitflag(this, enum.name.value) }
            putEntityIfNameReplaced(value)
        }
    }

    enumerations["VkResult".interned()]!!.variants.forEach {
        it.rename(::renameConstant)
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

private fun renameCommand(name: String) = name.removePrefix("vk").ensureLowerCamelCase()

private fun renameConstant(name: String) = if (name.startsWith("VK_")) {
    name.removePrefix("VK_")
} else if (name.startsWith("STD_VIDEO_")) {
    name.removePrefix("STD_VIDEO_")
} else {
    name
}

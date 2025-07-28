package club.doki7.babel.extract.gles2

import club.doki7.babel.extract.ensureLowerCamelCase
import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.Registry
import java.io.File

private const val renamedEntitiesFile = "codegen-v2/output/gles2-renamed-entities.csv"

internal fun Registry.renameEntities() {
    val renamed = mutableMapOf<String, String>()

    fun putEntityIfNameReplaced(entity: Entity) {
        if (entity.name.original != entity.name.value) {
            renamed.putIfAbsent(entity.name.original, entity.name.value)
        }
    }

    constants.forEach { it.value.rename(::renameConstant); putEntityIfNameReplaced(it.value) }
    commands.forEach { it.value.rename(::renameCommand); putEntityIfNameReplaced(it.value) }

    log.info(" - 重命名完成，重命名了 ${renamed.size} 个项目，完整列表可参见 $renamedEntitiesFile")
    File(renamedEntitiesFile).writeText(buildString {
        appendLine("original,new")
        for ((original, renamed) in renamed) {
            appendLine("$original,$renamed")
        }
    })
}

private fun renameConstant(name: String) = name.removePrefix("GL_").removeSuffix("_BIT")

private fun renameCommand(name: String) = name.removePrefix("gl").ensureLowerCamelCase()

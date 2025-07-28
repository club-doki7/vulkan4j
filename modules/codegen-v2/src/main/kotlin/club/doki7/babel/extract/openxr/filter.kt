package club.doki7.babel.extract.openxr

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.interned
import java.io.File

private const val unsupportedEntitiesFile = "codegen-v2/output/xr-unsupported-entities.txt"
private const val unsupportedExtensionsFile = "codegen-v2/output/xr-unsupported-extensions.txt"

internal fun Registry<OpenXRRegistryExt>.filterEntities(): Registry<OpenXRRegistryExt> {
    val unsupportedEntities = getUnsupportedEntities()
    log.info(" - 已过滤 ${unsupportedEntities.size} 个不支持的实体，完整列表可参见 $unsupportedEntitiesFile")

    fun <T: Entity> Map<Identifier, T>.filterSupportedEntities() =
        filter { !unsupportedEntities.contains(it.key) }
            .toMutableMap()

    File(unsupportedEntitiesFile).writeText(buildString {
        for (unsupportedEntity in unsupportedEntities) {
            appendLine(unsupportedEntity)
        }
    })

    val (extensions, unsupportedExtensions) = ext.extensions.values
        .partition { it.supported != "disabled" }
    log.info(" - 已过滤 ${unsupportedExtensions.size} 个不支持的扩展，完整列表可参见 $unsupportedExtensionsFile")
    File(unsupportedExtensionsFile).writeText(buildString {
        for (unsupportedExtension in unsupportedExtensions) {
            appendLine(unsupportedExtension.name)
        }
    })

    return Registry(
        aliases = aliases.filterSupportedEntities(),
        bitmasks = bitmasks.filterSupportedEntities(),
        constants = constants.filterSupportedEntities(),
        commands = commands.filterSupportedEntities(),
        enumerations = enumerations.filterSupportedEntities(),
        functionTypedefs = functionTypedefs.filterSupportedEntities(),
        opaqueHandleTypedefs = opaqueHandleTypedefs.filterSupportedEntities(),
        opaqueTypedefs = mutableMapOf(),
        structures = structures.filterSupportedEntities(),
        unions = unions.filterSupportedEntities(),
        ext = OpenXRRegistryExt(
            extensions = extensions.associateBy { it.name },
            versions = this.ext.versions
        )
    )
}

private fun Registry<OpenXRRegistryExt>.getUnsupportedEntities() = mutableSetOf<Identifier>().apply {
    val registry = this@getUnsupportedEntities
    addAll(registry.ext.extensions.values.filter {
        it.supported == "disabled"
    }.map { it.name })

    for (extension in registry.ext.extensions.values) {
        if (extension.supported == "disabled") {
            add(extension.name)
            for (require in extension.requires) {
                for (type in require.types) {
                    add(type.interned())
                }

                for (requireValue in require.values) {
                    add(requireValue.name)
                }

                for (command in require.commands) {
                    add(command)
                }
            }
        }
    }
}

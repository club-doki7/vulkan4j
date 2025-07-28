package club.doki7.babel.extract.vulkan

import club.doki7.sennaar.registry.*
import java.io.File

private const val unsupportedEntitiesFile = "codegen-v2/output/vulkan-unsupported-entities.txt"
private const val unsupportedExtensionsFile = "codegen-v2/output/vulkan-unsupported-extensions.txt"
private const val unsupportedVersionsFile = "codegen-v2/output/vulkan-unsupported-versions.txt"

internal fun Registry<VulkanRegistryExt>.filterEntities(): Registry<VulkanRegistryExt> {
    val unsupportedEntities = getUnsupportedEntities()
    log.info(" - 已过滤 ${unsupportedEntities.size} 个不支持的实体，完整列表可参见 $unsupportedEntitiesFile")

    fun <T: Entity> Map<Identifier, T>.filterSupportedEntities() =
        filter { !unsupportedEntities.contains(it.key) && it.value.isVulkanAPI() }
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

    val (versions, unsupportedVersions) = ext.versions.values
        .partition { it.isVulkanAPI() }
    log.info(" - 已过滤 ${unsupportedVersions.size} 个不支持的版本，完整列表可参见 $unsupportedVersionsFile")
    File(unsupportedVersionsFile).writeText(buildString {
        for (unsupportedVersion in unsupportedVersions) {
            appendLine(unsupportedVersion.name)
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
        ext = VulkanRegistryExt(
            extensions = extensions.associateBy { it.name },
            versions = versions.associateBy { it.name }
        )
    )
}

private fun Registry<VulkanRegistryExt>.getUnsupportedEntities() = mutableSetOf<Identifier>().apply {
    val registry = this@getUnsupportedEntities

    addAll(
        registry.ext.extensions.values
            .filter { it.supported == "disabled" || !it.isVulkanAPI() }
            .flatMap { it.require.commands + it.require.types.map { n -> n.interned() } }
    )

    val (vulkan, nonVulkan) = registry.ext.versions.values.partition { it.isVulkanAPI() }

    val vulkanEntities = vulkan
        .flatMap { it.require.commands + it.require.types.map { n -> n.interned() } }
        .toSet()

    addAll(
        nonVulkan
            .flatMap { it.require.commands + it.require.types.map { n -> n.interned() } }
            .filter { !vulkanEntities.contains(it) }
    )
}

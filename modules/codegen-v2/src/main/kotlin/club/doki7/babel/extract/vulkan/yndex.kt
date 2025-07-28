package club.doki7.babel.extract.vulkan

import club.doki7.sennaar.registry.ArrayType
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.interned
import java.util.logging.Logger

internal val log = Logger.getLogger("c.d.b.extract.vulkan")

fun extractVulkanRegistry(): Registry<VulkanRegistryExt> {
    log.info("抽取原始注册表")
    val rawRegistry = extractRawVulkanRegistry()

    log.info("过滤不支持的实体")
    val filteredRegistry = rawRegistry.filterEntities()

    log.info("扩展实体")
    filteredRegistry.extendEntities()

    log.info("执行重命名")
    filteredRegistry.renameEntities()

    log.info("手动添加类型 NvSciSyncFence")
    val renamedNvSciSyncFence = "NvSciSyncFence".interned()
    renamedNvSciSyncFence.rename("NvSciSyncFenceVKREF")
    filteredRegistry.structs.put(
        renamedNvSciSyncFence,
        Structure(
            name = renamedNvSciSyncFence,
            members = mutableListOf(Member(
                name = "payload",
                type = ArrayType(IdentifierType("uint64_t"), "6".interned()),
                values = null,
                len = null,
                altLen = null,
                optional = false,
                bits = null
            ))
        )
    )

    log.info("完成")
    return filteredRegistry
}

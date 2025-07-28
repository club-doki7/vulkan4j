package club.doki7.babel.extract.vulkan

import club.doki7.sennaar.registry.Entity
import club.doki7.sennaar.registry.IMergeable
import club.doki7.sennaar.Identifier

open class VkCommonMetadata(val api: String?) {
    override fun toString(): String = "VkCommonMetadata(api=\"$api\")"
}

class VkHandleMetadata(
    api: String?,
    val dispatchable: Boolean
) : VkCommonMetadata(api) {
    override fun toString() = "VkHandleMetadata(api=\"$api\", dispatchable=$dispatchable)"
}

class VkStructureMetadata(
    api: String?,
    val structExtends: List<Identifier>?
) : VkCommonMetadata(api) {
    override fun toString(): String = "VkStructureMetadata(api=\"$api\", structExtends=$structExtends)"
}

data class VulkanRegistryExt(
    val versions: Map<Identifier, VulkanVersion>,
    val extensions: Map<Identifier, Extension>,
) : IMergeable<VulkanRegistryExt> {
    override fun merge(other: VulkanRegistryExt): VulkanRegistryExt = VulkanRegistryExt(
        versions = this.versions + other.versions,
        extensions = this.extensions + other.extensions
    )
}

class VulkanVersion(
    name: String,
    api: String?,
    val number: Float,
    val require: Require
) : Entity(name, extra=VkCommonMetadata(api)) {

    override fun toStringImpl() = "VulkanVersion(name=\"$name\", number=$number, require=$require"
}

data class Require(
    val commands: Set<Identifier>,
    val types: Set<String>,
    val values: List<RequireValue>
)

class RequireValue(
    name: String,
    api: String?,
    val extends: Identifier?,
    val value: String?,
    val bitpos: Long?,
    val extNumber: Long?,
    val offset: Long?,
    val negative: Boolean
) : Entity(name, extra=VkCommonMetadata(api)) {
    override fun toStringImpl() = buildString {
        append("RequireValue(name=\"$name\",")
        if (extends != null) {
            append(", extends=\"$extends\"")
        }
        if (value != null) {
            append(", value=$value")
        }
        if (bitpos != null) {
            append(", bitpos=$bitpos")
        }
        if (extNumber != null) {
            append(", extNumber=$extNumber")
        }
        if (offset != null) {
            append(", offset=$offset")
        }
        append(", negative=$negative")
    }
}

class Extension(
    name: String,
    api: String?,
    val number: Long,
    val type: String?,
    val author: String,
    val contact: String,
    val platform: String?,
    val requires: String?,
    val requiresCore: String?,
    val deprecatedby: String?,
    val obsoletedby: String?,
    val promotedto: String?,
    val supported: String,
    val provisional: Boolean,
    val require: Require,
) : Entity(name, extra= VkCommonMetadata(api)) {
    override fun toStringImpl() = buildString {
        append("Extension(name=\"$name\", number=$number")
        if (type != null) {
            append(", type=$type")
        }
        append(", author=\"$author\"")
        append(", contact=\"$contact\"")
        if (platform != null) {
            append(", platform=\"$platform\"")
        }
        if (requires != null) {
            append(", requires=\"$requires\"")
        }
        if (requiresCore != null) {
            append(", requiresCore=\"$requiresCore\"")
        }
        if (deprecatedby != null) {
            append(", deprecatedby=\"$deprecatedby\"")
        }
        if (obsoletedby != null) {
            append(", obsoletedby=\"$obsoletedby\"")
        }
        if (promotedto != null) {
            append(", promotedto=\"$promotedto\"")
        }
        append(", supported=\"$supported\"")
        append(", provisional=$provisional")
        append(", require=$require")
    }
}

internal fun Entity.isVulkanAPI(): Boolean {
    val ext = this.ext<VkCommonMetadata>()
    return ext.api == null || ext.api.split(",").contains("vulkan")
}

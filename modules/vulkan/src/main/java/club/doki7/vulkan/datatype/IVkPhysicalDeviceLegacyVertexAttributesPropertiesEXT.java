package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLegacyVertexAttributesPropertiesEXT} and {@link VkPhysicalDeviceLegacyVertexAttributesPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLegacyVertexAttributesPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceLegacyVertexAttributesPropertiesEXT, VkPhysicalDeviceLegacyVertexAttributesPropertiesEXT.Ptr
{}

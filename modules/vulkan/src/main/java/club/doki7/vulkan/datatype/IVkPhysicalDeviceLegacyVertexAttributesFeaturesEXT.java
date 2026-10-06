package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLegacyVertexAttributesFeaturesEXT} and {@link VkPhysicalDeviceLegacyVertexAttributesFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLegacyVertexAttributesFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceLegacyVertexAttributesFeaturesEXT, VkPhysicalDeviceLegacyVertexAttributesFeaturesEXT.Ptr
{}

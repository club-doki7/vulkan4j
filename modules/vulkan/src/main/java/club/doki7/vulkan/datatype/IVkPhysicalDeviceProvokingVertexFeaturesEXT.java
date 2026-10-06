package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceProvokingVertexFeaturesEXT} and {@link VkPhysicalDeviceProvokingVertexFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceProvokingVertexFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceProvokingVertexFeaturesEXT, VkPhysicalDeviceProvokingVertexFeaturesEXT.Ptr
{}

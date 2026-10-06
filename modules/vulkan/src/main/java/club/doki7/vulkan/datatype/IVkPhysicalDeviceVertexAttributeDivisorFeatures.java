package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVertexAttributeDivisorFeatures} and {@link VkPhysicalDeviceVertexAttributeDivisorFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVertexAttributeDivisorFeatures
    extends IPointer
    permits VkPhysicalDeviceVertexAttributeDivisorFeatures, VkPhysicalDeviceVertexAttributeDivisorFeatures.Ptr
{}

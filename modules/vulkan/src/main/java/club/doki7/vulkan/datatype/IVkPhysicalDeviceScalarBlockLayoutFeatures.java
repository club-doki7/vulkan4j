package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceScalarBlockLayoutFeatures} and {@link VkPhysicalDeviceScalarBlockLayoutFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceScalarBlockLayoutFeatures
    extends IPointer
    permits VkPhysicalDeviceScalarBlockLayoutFeatures, VkPhysicalDeviceScalarBlockLayoutFeatures.Ptr
{}

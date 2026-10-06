package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentMeteringFeaturesNV} and {@link VkPhysicalDevicePresentMeteringFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentMeteringFeaturesNV
    extends IPointer
    permits VkPhysicalDevicePresentMeteringFeaturesNV, VkPhysicalDevicePresentMeteringFeaturesNV.Ptr
{}

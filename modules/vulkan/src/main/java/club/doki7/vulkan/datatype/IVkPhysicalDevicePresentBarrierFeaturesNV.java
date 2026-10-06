package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentBarrierFeaturesNV} and {@link VkPhysicalDevicePresentBarrierFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentBarrierFeaturesNV
    extends IPointer
    permits VkPhysicalDevicePresentBarrierFeaturesNV, VkPhysicalDevicePresentBarrierFeaturesNV.Ptr
{}

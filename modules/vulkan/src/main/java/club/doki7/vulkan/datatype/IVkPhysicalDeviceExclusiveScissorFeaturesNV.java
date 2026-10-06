package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExclusiveScissorFeaturesNV} and {@link VkPhysicalDeviceExclusiveScissorFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExclusiveScissorFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceExclusiveScissorFeaturesNV, VkPhysicalDeviceExclusiveScissorFeaturesNV.Ptr
{}

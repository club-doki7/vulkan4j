package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCopyMemoryIndirectFeaturesNV} and {@link VkPhysicalDeviceCopyMemoryIndirectFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCopyMemoryIndirectFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceCopyMemoryIndirectFeaturesNV, VkPhysicalDeviceCopyMemoryIndirectFeaturesNV.Ptr
{}

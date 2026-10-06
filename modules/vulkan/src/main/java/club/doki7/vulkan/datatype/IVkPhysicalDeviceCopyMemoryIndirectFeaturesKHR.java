package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCopyMemoryIndirectFeaturesKHR} and {@link VkPhysicalDeviceCopyMemoryIndirectFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCopyMemoryIndirectFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceCopyMemoryIndirectFeaturesKHR, VkPhysicalDeviceCopyMemoryIndirectFeaturesKHR.Ptr
{}

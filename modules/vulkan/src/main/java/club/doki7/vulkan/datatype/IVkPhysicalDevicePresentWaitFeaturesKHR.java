package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentWaitFeaturesKHR} and {@link VkPhysicalDevicePresentWaitFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentWaitFeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePresentWaitFeaturesKHR, VkPhysicalDevicePresentWaitFeaturesKHR.Ptr
{}

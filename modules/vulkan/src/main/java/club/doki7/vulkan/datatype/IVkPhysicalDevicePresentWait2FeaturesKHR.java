package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentWait2FeaturesKHR} and {@link VkPhysicalDevicePresentWait2FeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentWait2FeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePresentWait2FeaturesKHR, VkPhysicalDevicePresentWait2FeaturesKHR.Ptr
{}

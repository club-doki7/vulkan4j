package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentId2FeaturesKHR} and {@link VkPhysicalDevicePresentId2FeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentId2FeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePresentId2FeaturesKHR, VkPhysicalDevicePresentId2FeaturesKHR.Ptr
{}

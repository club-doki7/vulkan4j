package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePresentIdFeaturesKHR} and {@link VkPhysicalDevicePresentIdFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePresentIdFeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePresentIdFeaturesKHR, VkPhysicalDevicePresentIdFeaturesKHR.Ptr
{}

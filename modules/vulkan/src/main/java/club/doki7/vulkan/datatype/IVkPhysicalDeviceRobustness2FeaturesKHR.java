package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRobustness2FeaturesKHR} and {@link VkPhysicalDeviceRobustness2FeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRobustness2FeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceRobustness2FeaturesKHR, VkPhysicalDeviceRobustness2FeaturesKHR.Ptr
{}

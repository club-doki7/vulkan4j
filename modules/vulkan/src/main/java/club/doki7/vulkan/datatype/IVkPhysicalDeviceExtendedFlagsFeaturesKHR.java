package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExtendedFlagsFeaturesKHR} and {@link VkPhysicalDeviceExtendedFlagsFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExtendedFlagsFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceExtendedFlagsFeaturesKHR, VkPhysicalDeviceExtendedFlagsFeaturesKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFaultFeaturesKHR} and {@link VkPhysicalDeviceFaultFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFaultFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceFaultFeaturesKHR, VkPhysicalDeviceFaultFeaturesKHR.Ptr
{}

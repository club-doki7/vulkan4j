package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePerformanceQueryFeaturesKHR} and {@link VkPhysicalDevicePerformanceQueryFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePerformanceQueryFeaturesKHR
    extends IPointer
    permits VkPhysicalDevicePerformanceQueryFeaturesKHR, VkPhysicalDevicePerformanceQueryFeaturesKHR.Ptr
{}

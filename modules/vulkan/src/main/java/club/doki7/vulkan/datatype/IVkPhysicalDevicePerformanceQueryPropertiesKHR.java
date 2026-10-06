package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePerformanceQueryPropertiesKHR} and {@link VkPhysicalDevicePerformanceQueryPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePerformanceQueryPropertiesKHR
    extends IPointer
    permits VkPhysicalDevicePerformanceQueryPropertiesKHR, VkPhysicalDevicePerformanceQueryPropertiesKHR.Ptr
{}

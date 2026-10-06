package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM} and {@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePerformanceCountersByRegionPropertiesARM
    extends IPointer
    permits VkPhysicalDevicePerformanceCountersByRegionPropertiesARM, VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr
{}

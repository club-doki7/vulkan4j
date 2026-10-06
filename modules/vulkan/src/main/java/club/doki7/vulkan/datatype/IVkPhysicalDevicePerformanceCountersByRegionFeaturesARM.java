package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePerformanceCountersByRegionFeaturesARM} and {@link VkPhysicalDevicePerformanceCountersByRegionFeaturesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePerformanceCountersByRegionFeaturesARM
    extends IPointer
    permits VkPhysicalDevicePerformanceCountersByRegionFeaturesARM, VkPhysicalDevicePerformanceCountersByRegionFeaturesARM.Ptr
{}

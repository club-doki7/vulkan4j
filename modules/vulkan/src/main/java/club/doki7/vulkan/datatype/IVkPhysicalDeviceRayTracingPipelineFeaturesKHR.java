package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR} and {@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRayTracingPipelineFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceRayTracingPipelineFeaturesKHR, VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr
{}

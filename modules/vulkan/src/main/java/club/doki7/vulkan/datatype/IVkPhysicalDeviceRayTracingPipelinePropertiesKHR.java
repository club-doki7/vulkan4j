package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR} and {@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRayTracingPipelinePropertiesKHR
    extends IPointer
    permits VkPhysicalDeviceRayTracingPipelinePropertiesKHR, VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRayTracingPipelineCreateInfoKHR} and {@link VkRayTracingPipelineCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRayTracingPipelineCreateInfoKHR
    extends IPointer
    permits VkRayTracingPipelineCreateInfoKHR, VkRayTracingPipelineCreateInfoKHR.Ptr
{}

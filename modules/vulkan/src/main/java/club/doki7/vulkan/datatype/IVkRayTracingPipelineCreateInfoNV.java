package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRayTracingPipelineCreateInfoNV} and {@link VkRayTracingPipelineCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRayTracingPipelineCreateInfoNV
    extends IPointer
    permits VkRayTracingPipelineCreateInfoNV, VkRayTracingPipelineCreateInfoNV.Ptr
{}

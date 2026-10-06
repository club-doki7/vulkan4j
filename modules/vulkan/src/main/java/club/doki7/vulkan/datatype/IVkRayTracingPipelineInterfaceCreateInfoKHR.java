package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRayTracingPipelineInterfaceCreateInfoKHR} and {@link VkRayTracingPipelineInterfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRayTracingPipelineInterfaceCreateInfoKHR
    extends IPointer
    permits VkRayTracingPipelineInterfaceCreateInfoKHR, VkRayTracingPipelineInterfaceCreateInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRayTracingShaderGroupCreateInfoKHR} and {@link VkRayTracingShaderGroupCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRayTracingShaderGroupCreateInfoKHR
    extends IPointer
    permits VkRayTracingShaderGroupCreateInfoKHR, VkRayTracingShaderGroupCreateInfoKHR.Ptr
{}

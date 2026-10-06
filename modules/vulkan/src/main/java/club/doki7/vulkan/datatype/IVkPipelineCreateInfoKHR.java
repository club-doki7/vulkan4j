package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineCreateInfoKHR} and {@link VkPipelineCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineCreateInfoKHR
    extends IPointer
    permits VkPipelineCreateInfoKHR, VkPipelineCreateInfoKHR.Ptr
{}

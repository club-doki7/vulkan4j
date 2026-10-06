package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineInfoKHR} and {@link VkPipelineInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineInfoKHR
    extends IPointer
    permits VkPipelineInfoKHR, VkPipelineInfoKHR.Ptr
{}

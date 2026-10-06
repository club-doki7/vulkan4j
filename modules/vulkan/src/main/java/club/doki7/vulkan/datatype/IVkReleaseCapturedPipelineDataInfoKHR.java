package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkReleaseCapturedPipelineDataInfoKHR} and {@link VkReleaseCapturedPipelineDataInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkReleaseCapturedPipelineDataInfoKHR
    extends IPointer
    permits VkReleaseCapturedPipelineDataInfoKHR, VkReleaseCapturedPipelineDataInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineCreationFeedbackCreateInfo} and {@link VkPipelineCreationFeedbackCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineCreationFeedbackCreateInfo
    extends IPointer
    permits VkPipelineCreationFeedbackCreateInfo, VkPipelineCreationFeedbackCreateInfo.Ptr
{}

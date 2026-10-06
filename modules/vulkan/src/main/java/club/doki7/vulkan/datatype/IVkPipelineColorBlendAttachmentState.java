package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineColorBlendAttachmentState} and {@link VkPipelineColorBlendAttachmentState.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineColorBlendAttachmentState
    extends IPointer
    permits VkPipelineColorBlendAttachmentState, VkPipelineColorBlendAttachmentState.Ptr
{}

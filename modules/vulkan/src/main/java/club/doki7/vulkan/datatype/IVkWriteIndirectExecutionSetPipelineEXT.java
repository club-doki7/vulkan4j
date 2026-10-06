package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWriteIndirectExecutionSetPipelineEXT} and {@link VkWriteIndirectExecutionSetPipelineEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWriteIndirectExecutionSetPipelineEXT
    extends IPointer
    permits VkWriteIndirectExecutionSetPipelineEXT, VkWriteIndirectExecutionSetPipelineEXT.Ptr
{}

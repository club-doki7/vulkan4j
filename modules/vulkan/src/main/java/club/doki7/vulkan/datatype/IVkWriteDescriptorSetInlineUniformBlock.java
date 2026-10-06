package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWriteDescriptorSetInlineUniformBlock} and {@link VkWriteDescriptorSetInlineUniformBlock.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWriteDescriptorSetInlineUniformBlock
    extends IPointer
    permits VkWriteDescriptorSetInlineUniformBlock, VkWriteDescriptorSetInlineUniformBlock.Ptr
{}

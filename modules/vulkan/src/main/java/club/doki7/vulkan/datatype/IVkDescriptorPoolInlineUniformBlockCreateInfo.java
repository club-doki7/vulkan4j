package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorPoolInlineUniformBlockCreateInfo} and {@link VkDescriptorPoolInlineUniformBlockCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorPoolInlineUniformBlockCreateInfo
    extends IPointer
    permits VkDescriptorPoolInlineUniformBlockCreateInfo, VkDescriptorPoolInlineUniformBlockCreateInfo.Ptr
{}

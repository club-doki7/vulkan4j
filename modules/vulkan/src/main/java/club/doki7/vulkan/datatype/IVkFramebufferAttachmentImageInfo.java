package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFramebufferAttachmentImageInfo} and {@link VkFramebufferAttachmentImageInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFramebufferAttachmentImageInfo
    extends IPointer
    permits VkFramebufferAttachmentImageInfo, VkFramebufferAttachmentImageInfo.Ptr
{}

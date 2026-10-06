package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFramebufferAttachmentsCreateInfo} and {@link VkFramebufferAttachmentsCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFramebufferAttachmentsCreateInfo
    extends IPointer
    permits VkFramebufferAttachmentsCreateInfo, VkFramebufferAttachmentsCreateInfo.Ptr
{}

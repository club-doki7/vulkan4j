package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingAttachmentInfo} and {@link VkRenderingAttachmentInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingAttachmentInfo
    extends IPointer
    permits VkRenderingAttachmentInfo, VkRenderingAttachmentInfo.Ptr
{}

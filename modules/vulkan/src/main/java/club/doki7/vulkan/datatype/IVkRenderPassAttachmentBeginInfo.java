package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassAttachmentBeginInfo} and {@link VkRenderPassAttachmentBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassAttachmentBeginInfo
    extends IPointer
    permits VkRenderPassAttachmentBeginInfo, VkRenderPassAttachmentBeginInfo.Ptr
{}

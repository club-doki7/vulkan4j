package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassInputAttachmentAspectCreateInfo} and {@link VkRenderPassInputAttachmentAspectCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassInputAttachmentAspectCreateInfo
    extends IPointer
    permits VkRenderPassInputAttachmentAspectCreateInfo, VkRenderPassInputAttachmentAspectCreateInfo.Ptr
{}

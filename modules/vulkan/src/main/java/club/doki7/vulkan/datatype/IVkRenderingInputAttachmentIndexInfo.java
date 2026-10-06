package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingInputAttachmentIndexInfo} and {@link VkRenderingInputAttachmentIndexInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingInputAttachmentIndexInfo
    extends IPointer
    permits VkRenderingInputAttachmentIndexInfo, VkRenderingInputAttachmentIndexInfo.Ptr
{}

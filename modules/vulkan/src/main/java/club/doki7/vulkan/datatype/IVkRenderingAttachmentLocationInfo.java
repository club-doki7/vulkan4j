package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingAttachmentLocationInfo} and {@link VkRenderingAttachmentLocationInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingAttachmentLocationInfo
    extends IPointer
    permits VkRenderingAttachmentLocationInfo, VkRenderingAttachmentLocationInfo.Ptr
{}

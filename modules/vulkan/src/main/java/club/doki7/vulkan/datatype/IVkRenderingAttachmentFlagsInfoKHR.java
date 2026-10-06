package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingAttachmentFlagsInfoKHR} and {@link VkRenderingAttachmentFlagsInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingAttachmentFlagsInfoKHR
    extends IPointer
    permits VkRenderingAttachmentFlagsInfoKHR, VkRenderingAttachmentFlagsInfoKHR.Ptr
{}

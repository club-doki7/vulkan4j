package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClearAttachment} and {@link VkClearAttachment.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClearAttachment
    extends IPointer
    permits VkClearAttachment, VkClearAttachment.Ptr
{}

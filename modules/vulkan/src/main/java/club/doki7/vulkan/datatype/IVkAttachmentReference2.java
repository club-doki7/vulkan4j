package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentReference2} and {@link VkAttachmentReference2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentReference2
    extends IPointer
    permits VkAttachmentReference2, VkAttachmentReference2.Ptr
{}

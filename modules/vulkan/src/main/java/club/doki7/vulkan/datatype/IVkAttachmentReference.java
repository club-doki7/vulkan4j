package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentReference} and {@link VkAttachmentReference.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentReference
    extends IPointer
    permits VkAttachmentReference, VkAttachmentReference.Ptr
{}

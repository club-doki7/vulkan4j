package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkInputAttachmentAspectReference} and {@link VkInputAttachmentAspectReference.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkInputAttachmentAspectReference
    extends IPointer
    permits VkInputAttachmentAspectReference, VkInputAttachmentAspectReference.Ptr
{}

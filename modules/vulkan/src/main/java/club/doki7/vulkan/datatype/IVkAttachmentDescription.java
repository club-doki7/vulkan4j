package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentDescription} and {@link VkAttachmentDescription.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentDescription
    extends IPointer
    permits VkAttachmentDescription, VkAttachmentDescription.Ptr
{}

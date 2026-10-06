package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentDescription2} and {@link VkAttachmentDescription2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentDescription2
    extends IPointer
    permits VkAttachmentDescription2, VkAttachmentDescription2.Ptr
{}

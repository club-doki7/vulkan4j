package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentReferenceStencilLayout} and {@link VkAttachmentReferenceStencilLayout.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentReferenceStencilLayout
    extends IPointer
    permits VkAttachmentReferenceStencilLayout, VkAttachmentReferenceStencilLayout.Ptr
{}

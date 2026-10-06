package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentDescriptionStencilLayout} and {@link VkAttachmentDescriptionStencilLayout.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentDescriptionStencilLayout
    extends IPointer
    permits VkAttachmentDescriptionStencilLayout, VkAttachmentDescriptionStencilLayout.Ptr
{}

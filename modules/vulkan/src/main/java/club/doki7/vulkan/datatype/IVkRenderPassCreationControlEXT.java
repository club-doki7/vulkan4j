package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassCreationControlEXT} and {@link VkRenderPassCreationControlEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassCreationControlEXT
    extends IPointer
    permits VkRenderPassCreationControlEXT, VkRenderPassCreationControlEXT.Ptr
{}

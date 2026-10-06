package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageBlit} and {@link VkImageBlit.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageBlit
    extends IPointer
    permits VkImageBlit, VkImageBlit.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageBlit2} and {@link VkImageBlit2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageBlit2
    extends IPointer
    permits VkImageBlit2, VkImageBlit2.Ptr
{}

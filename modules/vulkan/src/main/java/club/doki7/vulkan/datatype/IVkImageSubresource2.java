package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSubresource2} and {@link VkImageSubresource2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSubresource2
    extends IPointer
    permits VkImageSubresource2, VkImageSubresource2.Ptr
{}

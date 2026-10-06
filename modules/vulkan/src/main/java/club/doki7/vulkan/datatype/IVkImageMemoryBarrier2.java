package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageMemoryBarrier2} and {@link VkImageMemoryBarrier2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageMemoryBarrier2
    extends IPointer
    permits VkImageMemoryBarrier2, VkImageMemoryBarrier2.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageMemoryBarrier} and {@link VkImageMemoryBarrier.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageMemoryBarrier
    extends IPointer
    permits VkImageMemoryBarrier, VkImageMemoryBarrier.Ptr
{}

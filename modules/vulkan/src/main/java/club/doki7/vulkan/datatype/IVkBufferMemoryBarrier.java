package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferMemoryBarrier} and {@link VkBufferMemoryBarrier.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferMemoryBarrier
    extends IPointer
    permits VkBufferMemoryBarrier, VkBufferMemoryBarrier.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferMemoryBarrier2} and {@link VkBufferMemoryBarrier2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferMemoryBarrier2
    extends IPointer
    permits VkBufferMemoryBarrier2, VkBufferMemoryBarrier2.Ptr
{}

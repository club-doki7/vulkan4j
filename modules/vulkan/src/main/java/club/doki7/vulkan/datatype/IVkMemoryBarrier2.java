package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryBarrier2} and {@link VkMemoryBarrier2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryBarrier2
    extends IPointer
    permits VkMemoryBarrier2, VkMemoryBarrier2.Ptr
{}

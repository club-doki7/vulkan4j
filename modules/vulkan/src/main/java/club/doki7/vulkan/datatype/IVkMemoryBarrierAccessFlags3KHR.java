package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryBarrierAccessFlags3KHR} and {@link VkMemoryBarrierAccessFlags3KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryBarrierAccessFlags3KHR
    extends IPointer
    permits VkMemoryBarrierAccessFlags3KHR, VkMemoryBarrierAccessFlags3KHR.Ptr
{}

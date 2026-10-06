package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAabbPositionsKHR} and {@link VkAabbPositionsKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAabbPositionsKHR
    extends IPointer
    permits VkAabbPositionsKHR, VkAabbPositionsKHR.Ptr
{}

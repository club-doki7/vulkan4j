package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindIndexBuffer3InfoKHR} and {@link VkBindIndexBuffer3InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindIndexBuffer3InfoKHR
    extends IPointer
    permits VkBindIndexBuffer3InfoKHR, VkBindIndexBuffer3InfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetFdInfoKHR} and {@link VkMemoryGetFdInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetFdInfoKHR
    extends IPointer
    permits VkMemoryGetFdInfoKHR, VkMemoryGetFdInfoKHR.Ptr
{}

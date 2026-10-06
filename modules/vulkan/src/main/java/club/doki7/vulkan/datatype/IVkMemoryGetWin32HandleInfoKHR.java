package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetWin32HandleInfoKHR} and {@link VkMemoryGetWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetWin32HandleInfoKHR
    extends IPointer
    permits VkMemoryGetWin32HandleInfoKHR, VkMemoryGetWin32HandleInfoKHR.Ptr
{}

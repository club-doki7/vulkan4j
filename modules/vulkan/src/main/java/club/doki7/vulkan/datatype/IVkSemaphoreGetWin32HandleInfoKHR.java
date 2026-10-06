package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreGetWin32HandleInfoKHR} and {@link VkSemaphoreGetWin32HandleInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreGetWin32HandleInfoKHR
    extends IPointer
    permits VkSemaphoreGetWin32HandleInfoKHR, VkSemaphoreGetWin32HandleInfoKHR.Ptr
{}

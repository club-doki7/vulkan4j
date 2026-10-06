package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreGetFdInfoKHR} and {@link VkSemaphoreGetFdInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreGetFdInfoKHR
    extends IPointer
    permits VkSemaphoreGetFdInfoKHR, VkSemaphoreGetFdInfoKHR.Ptr
{}

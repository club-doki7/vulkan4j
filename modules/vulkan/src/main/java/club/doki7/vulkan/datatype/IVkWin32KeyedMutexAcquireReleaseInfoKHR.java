package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWin32KeyedMutexAcquireReleaseInfoKHR} and {@link VkWin32KeyedMutexAcquireReleaseInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWin32KeyedMutexAcquireReleaseInfoKHR
    extends IPointer
    permits VkWin32KeyedMutexAcquireReleaseInfoKHR, VkWin32KeyedMutexAcquireReleaseInfoKHR.Ptr
{}

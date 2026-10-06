package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWin32KeyedMutexAcquireReleaseInfoNV} and {@link VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWin32KeyedMutexAcquireReleaseInfoNV
    extends IPointer
    permits VkWin32KeyedMutexAcquireReleaseInfoNV, VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr
{}

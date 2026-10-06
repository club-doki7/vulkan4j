package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAcquireProfilingLockInfoKHR} and {@link VkAcquireProfilingLockInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAcquireProfilingLockInfoKHR
    extends IPointer
    permits VkAcquireProfilingLockInfoKHR, VkAcquireProfilingLockInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreWaitInfo} and {@link VkSemaphoreWaitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreWaitInfo
    extends IPointer
    permits VkSemaphoreWaitInfo, VkSemaphoreWaitInfo.Ptr
{}

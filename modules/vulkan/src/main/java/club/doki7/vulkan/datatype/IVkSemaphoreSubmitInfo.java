package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreSubmitInfo} and {@link VkSemaphoreSubmitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreSubmitInfo
    extends IPointer
    permits VkSemaphoreSubmitInfo, VkSemaphoreSubmitInfo.Ptr
{}

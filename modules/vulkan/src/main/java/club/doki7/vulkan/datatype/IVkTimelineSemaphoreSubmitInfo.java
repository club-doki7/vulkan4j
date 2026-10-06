package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTimelineSemaphoreSubmitInfo} and {@link VkTimelineSemaphoreSubmitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTimelineSemaphoreSubmitInfo
    extends IPointer
    permits VkTimelineSemaphoreSubmitInfo, VkTimelineSemaphoreSubmitInfo.Ptr
{}

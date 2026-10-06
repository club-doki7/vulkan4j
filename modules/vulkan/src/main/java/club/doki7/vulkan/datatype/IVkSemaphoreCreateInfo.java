package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreCreateInfo} and {@link VkSemaphoreCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreCreateInfo
    extends IPointer
    permits VkSemaphoreCreateInfo, VkSemaphoreCreateInfo.Ptr
{}

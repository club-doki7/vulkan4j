package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferBeginInfo} and {@link VkCommandBufferBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferBeginInfo
    extends IPointer
    permits VkCommandBufferBeginInfo, VkCommandBufferBeginInfo.Ptr
{}

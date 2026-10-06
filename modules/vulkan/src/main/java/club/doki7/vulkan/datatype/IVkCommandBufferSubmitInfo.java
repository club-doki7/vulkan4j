package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferSubmitInfo} and {@link VkCommandBufferSubmitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferSubmitInfo
    extends IPointer
    permits VkCommandBufferSubmitInfo, VkCommandBufferSubmitInfo.Ptr
{}

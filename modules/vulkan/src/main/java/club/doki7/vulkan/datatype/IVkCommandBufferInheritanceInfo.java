package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferInheritanceInfo} and {@link VkCommandBufferInheritanceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferInheritanceInfo
    extends IPointer
    permits VkCommandBufferInheritanceInfo, VkCommandBufferInheritanceInfo.Ptr
{}

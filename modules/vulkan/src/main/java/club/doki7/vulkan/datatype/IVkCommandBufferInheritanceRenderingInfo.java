package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferInheritanceRenderingInfo} and {@link VkCommandBufferInheritanceRenderingInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferInheritanceRenderingInfo
    extends IPointer
    permits VkCommandBufferInheritanceRenderingInfo, VkCommandBufferInheritanceRenderingInfo.Ptr
{}

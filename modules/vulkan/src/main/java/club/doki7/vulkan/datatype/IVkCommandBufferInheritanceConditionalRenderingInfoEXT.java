package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferInheritanceConditionalRenderingInfoEXT} and {@link VkCommandBufferInheritanceConditionalRenderingInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferInheritanceConditionalRenderingInfoEXT
    extends IPointer
    permits VkCommandBufferInheritanceConditionalRenderingInfoEXT, VkCommandBufferInheritanceConditionalRenderingInfoEXT.Ptr
{}

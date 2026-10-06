package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassSubpassFeedbackCreateInfoEXT} and {@link VkRenderPassSubpassFeedbackCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassSubpassFeedbackCreateInfoEXT
    extends IPointer
    permits VkRenderPassSubpassFeedbackCreateInfoEXT, VkRenderPassSubpassFeedbackCreateInfoEXT.Ptr
{}

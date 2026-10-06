package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassSubpassFeedbackInfoEXT} and {@link VkRenderPassSubpassFeedbackInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassSubpassFeedbackInfoEXT
    extends IPointer
    permits VkRenderPassSubpassFeedbackInfoEXT, VkRenderPassSubpassFeedbackInfoEXT.Ptr
{}

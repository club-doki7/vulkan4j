package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassCreationFeedbackCreateInfoEXT} and {@link VkRenderPassCreationFeedbackCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassCreationFeedbackCreateInfoEXT
    extends IPointer
    permits VkRenderPassCreationFeedbackCreateInfoEXT, VkRenderPassCreationFeedbackCreateInfoEXT.Ptr
{}

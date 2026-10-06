package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassCreationFeedbackInfoEXT} and {@link VkRenderPassCreationFeedbackInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassCreationFeedbackInfoEXT
    extends IPointer
    permits VkRenderPassCreationFeedbackInfoEXT, VkRenderPassCreationFeedbackInfoEXT.Ptr
{}

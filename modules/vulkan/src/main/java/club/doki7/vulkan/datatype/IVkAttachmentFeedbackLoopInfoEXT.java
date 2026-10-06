package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentFeedbackLoopInfoEXT} and {@link VkAttachmentFeedbackLoopInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentFeedbackLoopInfoEXT
    extends IPointer
    permits VkAttachmentFeedbackLoopInfoEXT, VkAttachmentFeedbackLoopInfoEXT.Ptr
{}

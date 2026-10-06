package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindTransformFeedbackBuffer2InfoEXT} and {@link VkBindTransformFeedbackBuffer2InfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindTransformFeedbackBuffer2InfoEXT
    extends IPointer
    permits VkBindTransformFeedbackBuffer2InfoEXT, VkBindTransformFeedbackBuffer2InfoEXT.Ptr
{}

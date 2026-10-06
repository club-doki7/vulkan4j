package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceInlineUniformBlockFeatures} and {@link VkPhysicalDeviceInlineUniformBlockFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceInlineUniformBlockFeatures
    extends IPointer
    permits VkPhysicalDeviceInlineUniformBlockFeatures, VkPhysicalDeviceInlineUniformBlockFeatures.Ptr
{}

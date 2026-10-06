package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceInlineUniformBlockProperties} and {@link VkPhysicalDeviceInlineUniformBlockProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceInlineUniformBlockProperties
    extends IPointer
    permits VkPhysicalDeviceInlineUniformBlockProperties, VkPhysicalDeviceInlineUniformBlockProperties.Ptr
{}

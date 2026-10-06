package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageFormatProperties} and {@link VkImageFormatProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageFormatProperties
    extends IPointer
    permits VkImageFormatProperties, VkImageFormatProperties.Ptr
{}

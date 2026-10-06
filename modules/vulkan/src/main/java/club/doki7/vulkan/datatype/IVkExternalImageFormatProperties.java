package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalImageFormatProperties} and {@link VkExternalImageFormatProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalImageFormatProperties
    extends IPointer
    permits VkExternalImageFormatProperties, VkExternalImageFormatProperties.Ptr
{}

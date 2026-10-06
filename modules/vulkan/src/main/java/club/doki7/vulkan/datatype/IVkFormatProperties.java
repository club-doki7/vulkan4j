package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFormatProperties} and {@link VkFormatProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFormatProperties
    extends IPointer
    permits VkFormatProperties, VkFormatProperties.Ptr
{}

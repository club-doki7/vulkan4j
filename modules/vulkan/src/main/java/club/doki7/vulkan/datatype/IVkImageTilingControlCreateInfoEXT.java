package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageTilingControlCreateInfoEXT} and {@link VkImageTilingControlCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageTilingControlCreateInfoEXT
    extends IPointer
    permits VkImageTilingControlCreateInfoEXT, VkImageTilingControlCreateInfoEXT.Ptr
{}

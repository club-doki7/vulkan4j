package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewSlicedCreateInfoEXT} and {@link VkImageViewSlicedCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewSlicedCreateInfoEXT
    extends IPointer
    permits VkImageViewSlicedCreateInfoEXT, VkImageViewSlicedCreateInfoEXT.Ptr
{}

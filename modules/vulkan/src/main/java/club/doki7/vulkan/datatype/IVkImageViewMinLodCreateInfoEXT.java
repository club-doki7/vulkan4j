package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewMinLodCreateInfoEXT} and {@link VkImageViewMinLodCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewMinLodCreateInfoEXT
    extends IPointer
    permits VkImageViewMinLodCreateInfoEXT, VkImageViewMinLodCreateInfoEXT.Ptr
{}

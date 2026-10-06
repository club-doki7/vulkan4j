package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCustomResolveCreateInfoEXT} and {@link VkCustomResolveCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCustomResolveCreateInfoEXT
    extends IPointer
    permits VkCustomResolveCreateInfoEXT, VkCustomResolveCreateInfoEXT.Ptr
{}

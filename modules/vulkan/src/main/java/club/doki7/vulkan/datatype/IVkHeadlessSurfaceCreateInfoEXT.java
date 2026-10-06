package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHeadlessSurfaceCreateInfoEXT} and {@link VkHeadlessSurfaceCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHeadlessSurfaceCreateInfoEXT
    extends IPointer
    permits VkHeadlessSurfaceCreateInfoEXT, VkHeadlessSurfaceCreateInfoEXT.Ptr
{}

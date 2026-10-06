package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMetalSurfaceCreateInfoEXT} and {@link VkMetalSurfaceCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMetalSurfaceCreateInfoEXT
    extends IPointer
    permits VkMetalSurfaceCreateInfoEXT, VkMetalSurfaceCreateInfoEXT.Ptr
{}

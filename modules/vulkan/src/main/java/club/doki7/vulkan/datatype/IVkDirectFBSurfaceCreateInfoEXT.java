package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDirectFBSurfaceCreateInfoEXT} and {@link VkDirectFBSurfaceCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDirectFBSurfaceCreateInfoEXT
    extends IPointer
    permits VkDirectFBSurfaceCreateInfoEXT, VkDirectFBSurfaceCreateInfoEXT.Ptr
{}

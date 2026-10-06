package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCreateInfoOHOS} and {@link VkSurfaceCreateInfoOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCreateInfoOHOS
    extends IPointer
    permits VkSurfaceCreateInfoOHOS, VkSurfaceCreateInfoOHOS.Ptr
{}

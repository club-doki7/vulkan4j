package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkScreenSurfaceCreateInfoQNX} and {@link VkScreenSurfaceCreateInfoQNX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkScreenSurfaceCreateInfoQNX
    extends IPointer
    permits VkScreenSurfaceCreateInfoQNX, VkScreenSurfaceCreateInfoQNX.Ptr
{}

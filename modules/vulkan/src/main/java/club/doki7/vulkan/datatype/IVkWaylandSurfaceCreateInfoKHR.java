package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWaylandSurfaceCreateInfoKHR} and {@link VkWaylandSurfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWaylandSurfaceCreateInfoKHR
    extends IPointer
    permits VkWaylandSurfaceCreateInfoKHR, VkWaylandSurfaceCreateInfoKHR.Ptr
{}

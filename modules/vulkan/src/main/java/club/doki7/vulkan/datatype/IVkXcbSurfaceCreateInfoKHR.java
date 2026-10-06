package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkXcbSurfaceCreateInfoKHR} and {@link VkXcbSurfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkXcbSurfaceCreateInfoKHR
    extends IPointer
    permits VkXcbSurfaceCreateInfoKHR, VkXcbSurfaceCreateInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplaySurfaceCreateInfoKHR} and {@link VkDisplaySurfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplaySurfaceCreateInfoKHR
    extends IPointer
    permits VkDisplaySurfaceCreateInfoKHR, VkDisplaySurfaceCreateInfoKHR.Ptr
{}

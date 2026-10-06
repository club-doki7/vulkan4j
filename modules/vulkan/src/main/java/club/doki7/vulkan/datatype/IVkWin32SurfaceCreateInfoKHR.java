package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWin32SurfaceCreateInfoKHR} and {@link VkWin32SurfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWin32SurfaceCreateInfoKHR
    extends IPointer
    permits VkWin32SurfaceCreateInfoKHR, VkWin32SurfaceCreateInfoKHR.Ptr
{}

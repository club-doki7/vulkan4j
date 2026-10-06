package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAndroidSurfaceCreateInfoKHR} and {@link VkAndroidSurfaceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAndroidSurfaceCreateInfoKHR
    extends IPointer
    permits VkAndroidSurfaceCreateInfoKHR, VkAndroidSurfaceCreateInfoKHR.Ptr
{}

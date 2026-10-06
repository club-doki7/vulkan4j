package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkUbmSurfaceCreateInfoSEC} and {@link VkUbmSurfaceCreateInfoSEC.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkUbmSurfaceCreateInfoSEC
    extends IPointer
    permits VkUbmSurfaceCreateInfoSEC, VkUbmSurfaceCreateInfoSEC.Ptr
{}

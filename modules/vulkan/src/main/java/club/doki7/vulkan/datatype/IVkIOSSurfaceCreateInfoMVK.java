package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkIOSSurfaceCreateInfoMVK} and {@link VkIOSSurfaceCreateInfoMVK.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkIOSSurfaceCreateInfoMVK
    extends IPointer
    permits VkIOSSurfaceCreateInfoMVK, VkIOSSurfaceCreateInfoMVK.Ptr
{}

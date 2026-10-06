package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMacOSSurfaceCreateInfoMVK} and {@link VkMacOSSurfaceCreateInfoMVK.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMacOSSurfaceCreateInfoMVK
    extends IPointer
    permits VkMacOSSurfaceCreateInfoMVK, VkMacOSSurfaceCreateInfoMVK.Ptr
{}

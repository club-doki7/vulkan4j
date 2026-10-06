package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkStreamDescriptorSurfaceCreateInfoGGP} and {@link VkStreamDescriptorSurfaceCreateInfoGGP.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkStreamDescriptorSurfaceCreateInfoGGP
    extends IPointer
    permits VkStreamDescriptorSurfaceCreateInfoGGP, VkStreamDescriptorSurfaceCreateInfoGGP.Ptr
{}

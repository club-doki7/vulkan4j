package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImagePipeSurfaceCreateInfoFUCHSIA} and {@link VkImagePipeSurfaceCreateInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImagePipeSurfaceCreateInfoFUCHSIA
    extends IPointer
    permits VkImagePipeSurfaceCreateInfoFUCHSIA, VkImagePipeSurfaceCreateInfoFUCHSIA.Ptr
{}

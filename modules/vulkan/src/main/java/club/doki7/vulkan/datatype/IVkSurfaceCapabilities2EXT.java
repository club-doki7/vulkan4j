package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilities2EXT} and {@link VkSurfaceCapabilities2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilities2EXT
    extends IPointer
    permits VkSurfaceCapabilities2EXT, VkSurfaceCapabilities2EXT.Ptr
{}

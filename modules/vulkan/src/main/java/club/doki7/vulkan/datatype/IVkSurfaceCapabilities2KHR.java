package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilities2KHR} and {@link VkSurfaceCapabilities2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilities2KHR
    extends IPointer
    permits VkSurfaceCapabilities2KHR, VkSurfaceCapabilities2KHR.Ptr
{}

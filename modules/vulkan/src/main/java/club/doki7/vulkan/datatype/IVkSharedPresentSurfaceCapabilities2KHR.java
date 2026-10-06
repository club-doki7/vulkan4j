package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSharedPresentSurfaceCapabilities2KHR} and {@link VkSharedPresentSurfaceCapabilities2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSharedPresentSurfaceCapabilities2KHR
    extends IPointer
    permits VkSharedPresentSurfaceCapabilities2KHR, VkSharedPresentSurfaceCapabilities2KHR.Ptr
{}

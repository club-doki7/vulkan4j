package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSharedPresentSurfaceCapabilitiesKHR} and {@link VkSharedPresentSurfaceCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSharedPresentSurfaceCapabilitiesKHR
    extends IPointer
    permits VkSharedPresentSurfaceCapabilitiesKHR, VkSharedPresentSurfaceCapabilitiesKHR.Ptr
{}

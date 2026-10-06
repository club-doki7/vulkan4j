package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilitiesKHR} and {@link VkSurfaceCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilitiesKHR
    extends IPointer
    permits VkSurfaceCapabilitiesKHR, VkSurfaceCapabilitiesKHR.Ptr
{}

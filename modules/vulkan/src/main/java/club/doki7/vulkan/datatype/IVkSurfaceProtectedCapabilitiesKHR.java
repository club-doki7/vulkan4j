package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceProtectedCapabilitiesKHR} and {@link VkSurfaceProtectedCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceProtectedCapabilitiesKHR
    extends IPointer
    permits VkSurfaceProtectedCapabilitiesKHR, VkSurfaceProtectedCapabilitiesKHR.Ptr
{}

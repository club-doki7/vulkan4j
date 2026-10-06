package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilitiesPresentId2KHR} and {@link VkSurfaceCapabilitiesPresentId2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilitiesPresentId2KHR
    extends IPointer
    permits VkSurfaceCapabilitiesPresentId2KHR, VkSurfaceCapabilitiesPresentId2KHR.Ptr
{}

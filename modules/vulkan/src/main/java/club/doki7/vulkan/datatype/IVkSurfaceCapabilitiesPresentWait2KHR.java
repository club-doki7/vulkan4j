package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilitiesPresentWait2KHR} and {@link VkSurfaceCapabilitiesPresentWait2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilitiesPresentWait2KHR
    extends IPointer
    permits VkSurfaceCapabilitiesPresentWait2KHR, VkSurfaceCapabilitiesPresentWait2KHR.Ptr
{}

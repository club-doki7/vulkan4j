package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentTimingSurfaceCapabilitiesEXT} and {@link VkPresentTimingSurfaceCapabilitiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentTimingSurfaceCapabilitiesEXT
    extends IPointer
    permits VkPresentTimingSurfaceCapabilitiesEXT, VkPresentTimingSurfaceCapabilitiesEXT.Ptr
{}

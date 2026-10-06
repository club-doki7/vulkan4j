package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainFlagsSurfaceCapabilitiesEXT} and {@link VkSwapchainFlagsSurfaceCapabilitiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainFlagsSurfaceCapabilitiesEXT
    extends IPointer
    permits VkSwapchainFlagsSurfaceCapabilitiesEXT, VkSwapchainFlagsSurfaceCapabilitiesEXT.Ptr
{}

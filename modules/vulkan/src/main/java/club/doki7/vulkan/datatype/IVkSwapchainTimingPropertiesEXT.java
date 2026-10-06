package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainTimingPropertiesEXT} and {@link VkSwapchainTimingPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainTimingPropertiesEXT
    extends IPointer
    permits VkSwapchainTimingPropertiesEXT, VkSwapchainTimingPropertiesEXT.Ptr
{}

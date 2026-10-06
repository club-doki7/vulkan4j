package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainCounterCreateInfoEXT} and {@link VkSwapchainCounterCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainCounterCreateInfoEXT
    extends IPointer
    permits VkSwapchainCounterCreateInfoEXT, VkSwapchainCounterCreateInfoEXT.Ptr
{}

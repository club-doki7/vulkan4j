package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainCreateInfoKHR} and {@link VkSwapchainCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainCreateInfoKHR
    extends IPointer
    permits VkSwapchainCreateInfoKHR, VkSwapchainCreateInfoKHR.Ptr
{}

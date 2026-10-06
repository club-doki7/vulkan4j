package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageSwapchainCreateInfoKHR} and {@link VkImageSwapchainCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageSwapchainCreateInfoKHR
    extends IPointer
    permits VkImageSwapchainCreateInfoKHR, VkImageSwapchainCreateInfoKHR.Ptr
{}

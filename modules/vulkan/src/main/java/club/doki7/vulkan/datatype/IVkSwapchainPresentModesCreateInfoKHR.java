package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainPresentModesCreateInfoKHR} and {@link VkSwapchainPresentModesCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainPresentModesCreateInfoKHR
    extends IPointer
    permits VkSwapchainPresentModesCreateInfoKHR, VkSwapchainPresentModesCreateInfoKHR.Ptr
{}

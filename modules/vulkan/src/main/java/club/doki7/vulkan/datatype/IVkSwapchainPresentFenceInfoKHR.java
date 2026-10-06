package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainPresentFenceInfoKHR} and {@link VkSwapchainPresentFenceInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainPresentFenceInfoKHR
    extends IPointer
    permits VkSwapchainPresentFenceInfoKHR, VkSwapchainPresentFenceInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainPresentScalingCreateInfoKHR} and {@link VkSwapchainPresentScalingCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainPresentScalingCreateInfoKHR
    extends IPointer
    permits VkSwapchainPresentScalingCreateInfoKHR, VkSwapchainPresentScalingCreateInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupSwapchainCreateInfoKHR} and {@link VkDeviceGroupSwapchainCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupSwapchainCreateInfoKHR
    extends IPointer
    permits VkDeviceGroupSwapchainCreateInfoKHR, VkDeviceGroupSwapchainCreateInfoKHR.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkReleaseSwapchainImagesInfoKHR} and {@link VkReleaseSwapchainImagesInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkReleaseSwapchainImagesInfoKHR
    extends IPointer
    permits VkReleaseSwapchainImagesInfoKHR, VkReleaseSwapchainImagesInfoKHR.Ptr
{}

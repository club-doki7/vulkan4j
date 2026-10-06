package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindImageMemorySwapchainInfoKHR} and {@link VkBindImageMemorySwapchainInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindImageMemorySwapchainInfoKHR
    extends IPointer
    permits VkBindImageMemorySwapchainInfoKHR, VkBindImageMemorySwapchainInfoKHR.Ptr
{}

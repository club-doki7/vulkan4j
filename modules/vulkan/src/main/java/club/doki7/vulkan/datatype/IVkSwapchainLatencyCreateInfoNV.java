package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainLatencyCreateInfoNV} and {@link VkSwapchainLatencyCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainLatencyCreateInfoNV
    extends IPointer
    permits VkSwapchainLatencyCreateInfoNV, VkSwapchainLatencyCreateInfoNV.Ptr
{}

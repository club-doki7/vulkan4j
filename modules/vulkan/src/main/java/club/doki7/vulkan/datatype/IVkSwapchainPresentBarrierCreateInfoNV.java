package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainPresentBarrierCreateInfoNV} and {@link VkSwapchainPresentBarrierCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainPresentBarrierCreateInfoNV
    extends IPointer
    permits VkSwapchainPresentBarrierCreateInfoNV, VkSwapchainPresentBarrierCreateInfoNV.Ptr
{}

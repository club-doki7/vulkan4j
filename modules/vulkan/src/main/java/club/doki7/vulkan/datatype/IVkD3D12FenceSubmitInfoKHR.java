package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkD3D12FenceSubmitInfoKHR} and {@link VkD3D12FenceSubmitInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkD3D12FenceSubmitInfoKHR
    extends IPointer
    permits VkD3D12FenceSubmitInfoKHR, VkD3D12FenceSubmitInfoKHR.Ptr
{}

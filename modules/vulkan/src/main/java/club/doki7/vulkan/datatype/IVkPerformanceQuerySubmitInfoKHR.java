package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceQuerySubmitInfoKHR} and {@link VkPerformanceQuerySubmitInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceQuerySubmitInfoKHR
    extends IPointer
    permits VkPerformanceQuerySubmitInfoKHR, VkPerformanceQuerySubmitInfoKHR.Ptr
{}

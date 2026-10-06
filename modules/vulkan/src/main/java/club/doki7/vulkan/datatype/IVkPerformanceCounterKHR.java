package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceCounterKHR} and {@link VkPerformanceCounterKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceCounterKHR
    extends IPointer
    permits VkPerformanceCounterKHR, VkPerformanceCounterKHR.Ptr
{}

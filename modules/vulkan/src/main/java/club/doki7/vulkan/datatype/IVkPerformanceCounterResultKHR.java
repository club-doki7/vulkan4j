package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceCounterResultKHR} and {@link VkPerformanceCounterResultKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceCounterResultKHR
    extends IPointer
    permits VkPerformanceCounterResultKHR, VkPerformanceCounterResultKHR.Ptr
{}

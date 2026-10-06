package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueryPoolPerformanceCreateInfoKHR} and {@link VkQueryPoolPerformanceCreateInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueryPoolPerformanceCreateInfoKHR
    extends IPointer
    permits VkQueryPoolPerformanceCreateInfoKHR, VkQueryPoolPerformanceCreateInfoKHR.Ptr
{}

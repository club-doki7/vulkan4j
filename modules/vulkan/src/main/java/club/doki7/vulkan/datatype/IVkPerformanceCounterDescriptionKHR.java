package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceCounterDescriptionKHR} and {@link VkPerformanceCounterDescriptionKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceCounterDescriptionKHR
    extends IPointer
    permits VkPerformanceCounterDescriptionKHR, VkPerformanceCounterDescriptionKHR.Ptr
{}

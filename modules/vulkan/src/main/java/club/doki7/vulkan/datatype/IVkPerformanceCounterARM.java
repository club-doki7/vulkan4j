package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceCounterARM} and {@link VkPerformanceCounterARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceCounterARM
    extends IPointer
    permits VkPerformanceCounterARM, VkPerformanceCounterARM.Ptr
{}

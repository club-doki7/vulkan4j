package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceValueINTEL} and {@link VkPerformanceValueINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceValueINTEL
    extends IPointer
    permits VkPerformanceValueINTEL, VkPerformanceValueINTEL.Ptr
{}

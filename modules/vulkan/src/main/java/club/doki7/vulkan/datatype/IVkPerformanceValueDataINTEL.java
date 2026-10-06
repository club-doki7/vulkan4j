package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceValueDataINTEL} and {@link VkPerformanceValueDataINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceValueDataINTEL
    extends IPointer
    permits VkPerformanceValueDataINTEL, VkPerformanceValueDataINTEL.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueryPoolPerformanceQueryCreateInfoINTEL} and {@link VkQueryPoolPerformanceQueryCreateInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueryPoolPerformanceQueryCreateInfoINTEL
    extends IPointer
    permits VkQueryPoolPerformanceQueryCreateInfoINTEL, VkQueryPoolPerformanceQueryCreateInfoINTEL.Ptr
{}

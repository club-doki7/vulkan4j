package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceOverrideInfoINTEL} and {@link VkPerformanceOverrideInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceOverrideInfoINTEL
    extends IPointer
    permits VkPerformanceOverrideInfoINTEL, VkPerformanceOverrideInfoINTEL.Ptr
{}

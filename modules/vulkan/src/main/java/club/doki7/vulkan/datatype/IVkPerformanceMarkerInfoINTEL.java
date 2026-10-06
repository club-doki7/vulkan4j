package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceMarkerInfoINTEL} and {@link VkPerformanceMarkerInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceMarkerInfoINTEL
    extends IPointer
    permits VkPerformanceMarkerInfoINTEL, VkPerformanceMarkerInfoINTEL.Ptr
{}

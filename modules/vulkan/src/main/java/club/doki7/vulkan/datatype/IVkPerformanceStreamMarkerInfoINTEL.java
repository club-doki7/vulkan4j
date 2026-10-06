package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerformanceStreamMarkerInfoINTEL} and {@link VkPerformanceStreamMarkerInfoINTEL.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerformanceStreamMarkerInfoINTEL
    extends IPointer
    permits VkPerformanceStreamMarkerInfoINTEL, VkPerformanceStreamMarkerInfoINTEL.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassPerformanceCountersByRegionBeginInfoARM} and {@link VkRenderPassPerformanceCountersByRegionBeginInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassPerformanceCountersByRegionBeginInfoARM
    extends IPointer
    permits VkRenderPassPerformanceCountersByRegionBeginInfoARM, VkRenderPassPerformanceCountersByRegionBeginInfoARM.Ptr
{}

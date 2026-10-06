package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLatencyTimingsFrameReportNV} and {@link VkLatencyTimingsFrameReportNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLatencyTimingsFrameReportNV
    extends IPointer
    permits VkLatencyTimingsFrameReportNV, VkLatencyTimingsFrameReportNV.Ptr
{}

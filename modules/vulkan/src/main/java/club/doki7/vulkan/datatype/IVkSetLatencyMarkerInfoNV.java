package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSetLatencyMarkerInfoNV} and {@link VkSetLatencyMarkerInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSetLatencyMarkerInfoNV
    extends IPointer
    permits VkSetLatencyMarkerInfoNV, VkSetLatencyMarkerInfoNV.Ptr
{}

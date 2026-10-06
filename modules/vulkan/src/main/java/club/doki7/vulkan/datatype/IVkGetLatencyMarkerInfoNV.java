package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGetLatencyMarkerInfoNV} and {@link VkGetLatencyMarkerInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGetLatencyMarkerInfoNV
    extends IPointer
    permits VkGetLatencyMarkerInfoNV, VkGetLatencyMarkerInfoNV.Ptr
{}

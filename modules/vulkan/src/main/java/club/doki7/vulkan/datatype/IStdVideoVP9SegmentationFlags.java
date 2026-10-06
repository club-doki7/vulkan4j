package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9SegmentationFlags} and {@link StdVideoVP9SegmentationFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9SegmentationFlags
    extends IPointer
    permits StdVideoVP9SegmentationFlags, StdVideoVP9SegmentationFlags.Ptr
{}

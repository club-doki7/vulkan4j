package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265SliceSegmentHeaderFlags} and {@link StdVideoEncodeH265SliceSegmentHeaderFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265SliceSegmentHeaderFlags
    extends IPointer
    permits StdVideoEncodeH265SliceSegmentHeaderFlags, StdVideoEncodeH265SliceSegmentHeaderFlags.Ptr
{}

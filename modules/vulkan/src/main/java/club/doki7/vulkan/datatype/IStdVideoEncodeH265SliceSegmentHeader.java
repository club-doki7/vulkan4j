package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265SliceSegmentHeader} and {@link StdVideoEncodeH265SliceSegmentHeader.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265SliceSegmentHeader
    extends IPointer
    permits StdVideoEncodeH265SliceSegmentHeader, StdVideoEncodeH265SliceSegmentHeader.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265LongTermRefPics} and {@link StdVideoEncodeH265LongTermRefPics.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265LongTermRefPics
    extends IPointer
    permits StdVideoEncodeH265LongTermRefPics, StdVideoEncodeH265LongTermRefPics.Ptr
{}

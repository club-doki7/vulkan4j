package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264SliceHeader} and {@link StdVideoEncodeH264SliceHeader.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264SliceHeader
    extends IPointer
    permits StdVideoEncodeH264SliceHeader, StdVideoEncodeH264SliceHeader.Ptr
{}

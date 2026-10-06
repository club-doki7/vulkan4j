package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265PictureInfo} and {@link StdVideoEncodeH265PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265PictureInfo
    extends IPointer
    permits StdVideoEncodeH265PictureInfo, StdVideoEncodeH265PictureInfo.Ptr
{}

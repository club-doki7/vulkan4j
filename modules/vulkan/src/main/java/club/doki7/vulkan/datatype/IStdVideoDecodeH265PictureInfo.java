package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH265PictureInfo} and {@link StdVideoDecodeH265PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH265PictureInfo
    extends IPointer
    permits StdVideoDecodeH265PictureInfo, StdVideoDecodeH265PictureInfo.Ptr
{}

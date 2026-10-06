package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH264PictureInfo} and {@link StdVideoDecodeH264PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH264PictureInfo
    extends IPointer
    permits StdVideoDecodeH264PictureInfo, StdVideoDecodeH264PictureInfo.Ptr
{}

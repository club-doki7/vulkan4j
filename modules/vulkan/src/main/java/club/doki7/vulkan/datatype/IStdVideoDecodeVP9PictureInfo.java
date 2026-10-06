package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeVP9PictureInfo} and {@link StdVideoDecodeVP9PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeVP9PictureInfo
    extends IPointer
    permits StdVideoDecodeVP9PictureInfo, StdVideoDecodeVP9PictureInfo.Ptr
{}

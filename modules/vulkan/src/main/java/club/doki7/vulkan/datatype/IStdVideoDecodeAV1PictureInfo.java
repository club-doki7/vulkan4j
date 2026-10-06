package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeAV1PictureInfo} and {@link StdVideoDecodeAV1PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeAV1PictureInfo
    extends IPointer
    permits StdVideoDecodeAV1PictureInfo, StdVideoDecodeAV1PictureInfo.Ptr
{}

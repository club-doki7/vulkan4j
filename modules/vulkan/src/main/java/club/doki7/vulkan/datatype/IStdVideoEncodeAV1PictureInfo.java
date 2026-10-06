package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1PictureInfo} and {@link StdVideoEncodeAV1PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1PictureInfo
    extends IPointer
    permits StdVideoEncodeAV1PictureInfo, StdVideoEncodeAV1PictureInfo.Ptr
{}

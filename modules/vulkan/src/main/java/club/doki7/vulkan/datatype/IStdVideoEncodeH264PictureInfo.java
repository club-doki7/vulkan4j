package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264PictureInfo} and {@link StdVideoEncodeH264PictureInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264PictureInfo
    extends IPointer
    permits StdVideoEncodeH264PictureInfo, StdVideoEncodeH264PictureInfo.Ptr
{}

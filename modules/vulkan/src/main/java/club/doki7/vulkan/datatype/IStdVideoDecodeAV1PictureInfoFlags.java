package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeAV1PictureInfoFlags} and {@link StdVideoDecodeAV1PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeAV1PictureInfoFlags
    extends IPointer
    permits StdVideoDecodeAV1PictureInfoFlags, StdVideoDecodeAV1PictureInfoFlags.Ptr
{}

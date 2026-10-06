package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1PictureInfoFlags} and {@link StdVideoEncodeAV1PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1PictureInfoFlags
    extends IPointer
    permits StdVideoEncodeAV1PictureInfoFlags, StdVideoEncodeAV1PictureInfoFlags.Ptr
{}

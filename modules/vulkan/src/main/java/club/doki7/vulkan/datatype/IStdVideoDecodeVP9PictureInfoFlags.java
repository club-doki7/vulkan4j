package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeVP9PictureInfoFlags} and {@link StdVideoDecodeVP9PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeVP9PictureInfoFlags
    extends IPointer
    permits StdVideoDecodeVP9PictureInfoFlags, StdVideoDecodeVP9PictureInfoFlags.Ptr
{}

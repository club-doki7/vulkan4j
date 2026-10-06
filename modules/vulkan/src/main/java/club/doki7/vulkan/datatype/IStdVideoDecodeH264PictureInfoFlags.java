package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH264PictureInfoFlags} and {@link StdVideoDecodeH264PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH264PictureInfoFlags
    extends IPointer
    permits StdVideoDecodeH264PictureInfoFlags, StdVideoDecodeH264PictureInfoFlags.Ptr
{}

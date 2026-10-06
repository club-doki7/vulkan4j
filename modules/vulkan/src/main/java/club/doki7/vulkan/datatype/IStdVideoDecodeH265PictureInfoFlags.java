package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH265PictureInfoFlags} and {@link StdVideoDecodeH265PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH265PictureInfoFlags
    extends IPointer
    permits StdVideoDecodeH265PictureInfoFlags, StdVideoDecodeH265PictureInfoFlags.Ptr
{}

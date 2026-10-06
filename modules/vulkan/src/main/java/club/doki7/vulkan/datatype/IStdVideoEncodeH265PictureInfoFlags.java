package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265PictureInfoFlags} and {@link StdVideoEncodeH265PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265PictureInfoFlags
    extends IPointer
    permits StdVideoEncodeH265PictureInfoFlags, StdVideoEncodeH265PictureInfoFlags.Ptr
{}

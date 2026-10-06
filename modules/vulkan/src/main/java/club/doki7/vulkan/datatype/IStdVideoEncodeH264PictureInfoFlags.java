package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264PictureInfoFlags} and {@link StdVideoEncodeH264PictureInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264PictureInfoFlags
    extends IPointer
    permits StdVideoEncodeH264PictureInfoFlags, StdVideoEncodeH264PictureInfoFlags.Ptr
{}

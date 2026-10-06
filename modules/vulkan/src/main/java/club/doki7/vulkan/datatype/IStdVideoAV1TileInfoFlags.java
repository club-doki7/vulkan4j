package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1TileInfoFlags} and {@link StdVideoAV1TileInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1TileInfoFlags
    extends IPointer
    permits StdVideoAV1TileInfoFlags, StdVideoAV1TileInfoFlags.Ptr
{}

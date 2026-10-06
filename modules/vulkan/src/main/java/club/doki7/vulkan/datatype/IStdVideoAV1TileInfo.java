package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1TileInfo} and {@link StdVideoAV1TileInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1TileInfo
    extends IPointer
    permits StdVideoAV1TileInfo, StdVideoAV1TileInfo.Ptr
{}

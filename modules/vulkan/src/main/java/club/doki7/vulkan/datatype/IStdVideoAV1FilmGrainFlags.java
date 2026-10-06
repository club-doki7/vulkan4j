package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1FilmGrainFlags} and {@link StdVideoAV1FilmGrainFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1FilmGrainFlags
    extends IPointer
    permits StdVideoAV1FilmGrainFlags, StdVideoAV1FilmGrainFlags.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1FilmGrain} and {@link StdVideoAV1FilmGrain.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1FilmGrain
    extends IPointer
    permits StdVideoAV1FilmGrain, StdVideoAV1FilmGrain.Ptr
{}

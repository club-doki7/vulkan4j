package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1LoopRestoration} and {@link StdVideoAV1LoopRestoration.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1LoopRestoration
    extends IPointer
    permits StdVideoAV1LoopRestoration, StdVideoAV1LoopRestoration.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1LoopFilterFlags} and {@link StdVideoAV1LoopFilterFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1LoopFilterFlags
    extends IPointer
    permits StdVideoAV1LoopFilterFlags, StdVideoAV1LoopFilterFlags.Ptr
{}

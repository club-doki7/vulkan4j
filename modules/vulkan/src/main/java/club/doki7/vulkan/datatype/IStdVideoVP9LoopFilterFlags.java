package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9LoopFilterFlags} and {@link StdVideoVP9LoopFilterFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9LoopFilterFlags
    extends IPointer
    permits StdVideoVP9LoopFilterFlags, StdVideoVP9LoopFilterFlags.Ptr
{}

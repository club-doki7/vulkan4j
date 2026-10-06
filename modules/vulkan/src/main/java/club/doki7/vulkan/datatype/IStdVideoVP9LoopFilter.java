package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9LoopFilter} and {@link StdVideoVP9LoopFilter.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9LoopFilter
    extends IPointer
    permits StdVideoVP9LoopFilter, StdVideoVP9LoopFilter.Ptr
{}

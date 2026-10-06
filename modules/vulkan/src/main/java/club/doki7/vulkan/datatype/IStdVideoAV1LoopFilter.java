package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1LoopFilter} and {@link StdVideoAV1LoopFilter.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1LoopFilter
    extends IPointer
    permits StdVideoAV1LoopFilter, StdVideoAV1LoopFilter.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1SequenceHeader} and {@link StdVideoAV1SequenceHeader.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1SequenceHeader
    extends IPointer
    permits StdVideoAV1SequenceHeader, StdVideoAV1SequenceHeader.Ptr
{}

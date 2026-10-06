package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1SequenceHeaderFlags} and {@link StdVideoAV1SequenceHeaderFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1SequenceHeaderFlags
    extends IPointer
    permits StdVideoAV1SequenceHeaderFlags, StdVideoAV1SequenceHeaderFlags.Ptr
{}

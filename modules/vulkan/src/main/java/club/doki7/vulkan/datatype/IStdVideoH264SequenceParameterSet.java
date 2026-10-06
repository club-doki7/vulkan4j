package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264SequenceParameterSet} and {@link StdVideoH264SequenceParameterSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264SequenceParameterSet
    extends IPointer
    permits StdVideoH264SequenceParameterSet, StdVideoH264SequenceParameterSet.Ptr
{}

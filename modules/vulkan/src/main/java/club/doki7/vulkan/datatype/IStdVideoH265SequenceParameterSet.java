package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265SequenceParameterSet} and {@link StdVideoH265SequenceParameterSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265SequenceParameterSet
    extends IPointer
    permits StdVideoH265SequenceParameterSet, StdVideoH265SequenceParameterSet.Ptr
{}

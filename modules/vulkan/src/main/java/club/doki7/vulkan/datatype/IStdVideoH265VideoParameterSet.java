package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265VideoParameterSet} and {@link StdVideoH265VideoParameterSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265VideoParameterSet
    extends IPointer
    permits StdVideoH265VideoParameterSet, StdVideoH265VideoParameterSet.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265HrdParameters} and {@link StdVideoH265HrdParameters.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265HrdParameters
    extends IPointer
    permits StdVideoH265HrdParameters, StdVideoH265HrdParameters.Ptr
{}

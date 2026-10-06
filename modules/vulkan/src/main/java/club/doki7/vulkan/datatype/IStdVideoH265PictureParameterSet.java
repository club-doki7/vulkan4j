package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265PictureParameterSet} and {@link StdVideoH265PictureParameterSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265PictureParameterSet
    extends IPointer
    permits StdVideoH265PictureParameterSet, StdVideoH265PictureParameterSet.Ptr
{}

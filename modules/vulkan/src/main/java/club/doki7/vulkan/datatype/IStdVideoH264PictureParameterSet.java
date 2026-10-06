package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264PictureParameterSet} and {@link StdVideoH264PictureParameterSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264PictureParameterSet
    extends IPointer
    permits StdVideoH264PictureParameterSet, StdVideoH264PictureParameterSet.Ptr
{}

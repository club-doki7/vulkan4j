package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264ScalingLists} and {@link StdVideoH264ScalingLists.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264ScalingLists
    extends IPointer
    permits StdVideoH264ScalingLists, StdVideoH264ScalingLists.Ptr
{}

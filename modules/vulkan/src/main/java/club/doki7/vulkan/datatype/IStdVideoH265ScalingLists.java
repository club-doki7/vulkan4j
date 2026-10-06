package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265ScalingLists} and {@link StdVideoH265ScalingLists.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265ScalingLists
    extends IPointer
    permits StdVideoH265ScalingLists, StdVideoH265ScalingLists.Ptr
{}

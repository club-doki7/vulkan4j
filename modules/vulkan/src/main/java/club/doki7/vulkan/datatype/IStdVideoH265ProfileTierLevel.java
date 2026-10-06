package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265ProfileTierLevel} and {@link StdVideoH265ProfileTierLevel.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265ProfileTierLevel
    extends IPointer
    permits StdVideoH265ProfileTierLevel, StdVideoH265ProfileTierLevel.Ptr
{}

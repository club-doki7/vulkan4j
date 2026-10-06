package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265ProfileTierLevelFlags} and {@link StdVideoH265ProfileTierLevelFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265ProfileTierLevelFlags
    extends IPointer
    permits StdVideoH265ProfileTierLevelFlags, StdVideoH265ProfileTierLevelFlags.Ptr
{}

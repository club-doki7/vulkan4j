package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265ShortTermRefPicSetFlags} and {@link StdVideoH265ShortTermRefPicSetFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265ShortTermRefPicSetFlags
    extends IPointer
    permits StdVideoH265ShortTermRefPicSetFlags, StdVideoH265ShortTermRefPicSetFlags.Ptr
{}

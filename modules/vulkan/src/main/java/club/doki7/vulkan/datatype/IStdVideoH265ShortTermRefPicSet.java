package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265ShortTermRefPicSet} and {@link StdVideoH265ShortTermRefPicSet.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265ShortTermRefPicSet
    extends IPointer
    permits StdVideoH265ShortTermRefPicSet, StdVideoH265ShortTermRefPicSet.Ptr
{}

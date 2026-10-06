package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265HrdFlags} and {@link StdVideoH265HrdFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265HrdFlags
    extends IPointer
    permits StdVideoH265HrdFlags, StdVideoH265HrdFlags.Ptr
{}

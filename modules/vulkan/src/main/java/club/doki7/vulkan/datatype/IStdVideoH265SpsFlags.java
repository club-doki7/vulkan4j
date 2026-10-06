package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265SpsFlags} and {@link StdVideoH265SpsFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265SpsFlags
    extends IPointer
    permits StdVideoH265SpsFlags, StdVideoH265SpsFlags.Ptr
{}

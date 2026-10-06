package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265PpsFlags} and {@link StdVideoH265PpsFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265PpsFlags
    extends IPointer
    permits StdVideoH265PpsFlags, StdVideoH265PpsFlags.Ptr
{}

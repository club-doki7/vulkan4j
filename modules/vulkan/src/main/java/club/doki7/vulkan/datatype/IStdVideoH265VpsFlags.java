package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265VpsFlags} and {@link StdVideoH265VpsFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265VpsFlags
    extends IPointer
    permits StdVideoH265VpsFlags, StdVideoH265VpsFlags.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264SpsFlags} and {@link StdVideoH264SpsFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264SpsFlags
    extends IPointer
    permits StdVideoH264SpsFlags, StdVideoH264SpsFlags.Ptr
{}

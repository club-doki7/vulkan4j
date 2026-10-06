package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264PpsFlags} and {@link StdVideoH264PpsFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264PpsFlags
    extends IPointer
    permits StdVideoH264PpsFlags, StdVideoH264PpsFlags.Ptr
{}

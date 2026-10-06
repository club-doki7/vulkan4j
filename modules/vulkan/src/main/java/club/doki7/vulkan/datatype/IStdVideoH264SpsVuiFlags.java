package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264SpsVuiFlags} and {@link StdVideoH264SpsVuiFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264SpsVuiFlags
    extends IPointer
    permits StdVideoH264SpsVuiFlags, StdVideoH264SpsVuiFlags.Ptr
{}

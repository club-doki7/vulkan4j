package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265SpsVuiFlags} and {@link StdVideoH265SpsVuiFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265SpsVuiFlags
    extends IPointer
    permits StdVideoH265SpsVuiFlags, StdVideoH265SpsVuiFlags.Ptr
{}

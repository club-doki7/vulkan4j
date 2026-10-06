package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264SliceHeaderFlags} and {@link StdVideoEncodeH264SliceHeaderFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264SliceHeaderFlags
    extends IPointer
    permits StdVideoEncodeH264SliceHeaderFlags, StdVideoEncodeH264SliceHeaderFlags.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264WeightTableFlags} and {@link StdVideoEncodeH264WeightTableFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264WeightTableFlags
    extends IPointer
    permits StdVideoEncodeH264WeightTableFlags, StdVideoEncodeH264WeightTableFlags.Ptr
{}

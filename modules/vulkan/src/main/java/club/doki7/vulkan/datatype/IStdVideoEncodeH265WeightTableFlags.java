package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265WeightTableFlags} and {@link StdVideoEncodeH265WeightTableFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265WeightTableFlags
    extends IPointer
    permits StdVideoEncodeH265WeightTableFlags, StdVideoEncodeH265WeightTableFlags.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265WeightTable} and {@link StdVideoEncodeH265WeightTable.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265WeightTable
    extends IPointer
    permits StdVideoEncodeH265WeightTable, StdVideoEncodeH265WeightTable.Ptr
{}

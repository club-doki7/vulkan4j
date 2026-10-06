package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264WeightTable} and {@link StdVideoEncodeH264WeightTable.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264WeightTable
    extends IPointer
    permits StdVideoEncodeH264WeightTable, StdVideoEncodeH264WeightTable.Ptr
{}

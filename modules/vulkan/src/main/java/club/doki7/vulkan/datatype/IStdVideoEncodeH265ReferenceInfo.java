package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265ReferenceInfo} and {@link StdVideoEncodeH265ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265ReferenceInfo
    extends IPointer
    permits StdVideoEncodeH265ReferenceInfo, StdVideoEncodeH265ReferenceInfo.Ptr
{}

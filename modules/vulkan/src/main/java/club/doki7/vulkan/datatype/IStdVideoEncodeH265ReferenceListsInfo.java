package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265ReferenceListsInfo} and {@link StdVideoEncodeH265ReferenceListsInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265ReferenceListsInfo
    extends IPointer
    permits StdVideoEncodeH265ReferenceListsInfo, StdVideoEncodeH265ReferenceListsInfo.Ptr
{}

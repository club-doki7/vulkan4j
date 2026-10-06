package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264ReferenceListsInfo} and {@link StdVideoEncodeH264ReferenceListsInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264ReferenceListsInfo
    extends IPointer
    permits StdVideoEncodeH264ReferenceListsInfo, StdVideoEncodeH264ReferenceListsInfo.Ptr
{}

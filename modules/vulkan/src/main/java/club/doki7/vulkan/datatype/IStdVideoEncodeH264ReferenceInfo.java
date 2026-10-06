package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264ReferenceInfo} and {@link StdVideoEncodeH264ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264ReferenceInfo
    extends IPointer
    permits StdVideoEncodeH264ReferenceInfo, StdVideoEncodeH264ReferenceInfo.Ptr
{}

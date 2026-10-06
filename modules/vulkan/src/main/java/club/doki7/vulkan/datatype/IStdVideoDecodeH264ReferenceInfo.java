package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH264ReferenceInfo} and {@link StdVideoDecodeH264ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH264ReferenceInfo
    extends IPointer
    permits StdVideoDecodeH264ReferenceInfo, StdVideoDecodeH264ReferenceInfo.Ptr
{}

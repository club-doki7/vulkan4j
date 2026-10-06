package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeAV1ReferenceInfo} and {@link StdVideoDecodeAV1ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeAV1ReferenceInfo
    extends IPointer
    permits StdVideoDecodeAV1ReferenceInfo, StdVideoDecodeAV1ReferenceInfo.Ptr
{}

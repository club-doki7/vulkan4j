package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1ReferenceInfo} and {@link StdVideoEncodeAV1ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1ReferenceInfo
    extends IPointer
    permits StdVideoEncodeAV1ReferenceInfo, StdVideoEncodeAV1ReferenceInfo.Ptr
{}

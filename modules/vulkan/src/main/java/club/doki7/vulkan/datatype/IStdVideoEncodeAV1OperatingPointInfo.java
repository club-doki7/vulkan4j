package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1OperatingPointInfo} and {@link StdVideoEncodeAV1OperatingPointInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1OperatingPointInfo
    extends IPointer
    permits StdVideoEncodeAV1OperatingPointInfo, StdVideoEncodeAV1OperatingPointInfo.Ptr
{}

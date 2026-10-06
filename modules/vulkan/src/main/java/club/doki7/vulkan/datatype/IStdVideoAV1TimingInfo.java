package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1TimingInfo} and {@link StdVideoAV1TimingInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1TimingInfo
    extends IPointer
    permits StdVideoAV1TimingInfo, StdVideoAV1TimingInfo.Ptr
{}

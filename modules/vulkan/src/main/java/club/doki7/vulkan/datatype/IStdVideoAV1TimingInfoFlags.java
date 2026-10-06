package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1TimingInfoFlags} and {@link StdVideoAV1TimingInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1TimingInfoFlags
    extends IPointer
    permits StdVideoAV1TimingInfoFlags, StdVideoAV1TimingInfoFlags.Ptr
{}

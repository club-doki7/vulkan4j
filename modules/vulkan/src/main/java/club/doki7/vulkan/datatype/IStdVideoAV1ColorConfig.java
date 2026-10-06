package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1ColorConfig} and {@link StdVideoAV1ColorConfig.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1ColorConfig
    extends IPointer
    permits StdVideoAV1ColorConfig, StdVideoAV1ColorConfig.Ptr
{}

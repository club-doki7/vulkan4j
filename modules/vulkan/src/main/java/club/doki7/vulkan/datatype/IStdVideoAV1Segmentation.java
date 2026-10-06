package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1Segmentation} and {@link StdVideoAV1Segmentation.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1Segmentation
    extends IPointer
    permits StdVideoAV1Segmentation, StdVideoAV1Segmentation.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9Segmentation} and {@link StdVideoVP9Segmentation.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9Segmentation
    extends IPointer
    permits StdVideoVP9Segmentation, StdVideoVP9Segmentation.Ptr
{}

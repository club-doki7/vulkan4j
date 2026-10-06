package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1Quantization} and {@link StdVideoAV1Quantization.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1Quantization
    extends IPointer
    permits StdVideoAV1Quantization, StdVideoAV1Quantization.Ptr
{}

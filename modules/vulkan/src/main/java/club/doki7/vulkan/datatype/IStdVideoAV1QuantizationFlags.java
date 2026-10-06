package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1QuantizationFlags} and {@link StdVideoAV1QuantizationFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1QuantizationFlags
    extends IPointer
    permits StdVideoAV1QuantizationFlags, StdVideoAV1QuantizationFlags.Ptr
{}

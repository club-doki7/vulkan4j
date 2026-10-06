package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1OperatingPointInfoFlags} and {@link StdVideoEncodeAV1OperatingPointInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1OperatingPointInfoFlags
    extends IPointer
    permits StdVideoEncodeAV1OperatingPointInfoFlags, StdVideoEncodeAV1OperatingPointInfoFlags.Ptr
{}

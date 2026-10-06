package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeAV1ReferenceInfoFlags} and {@link StdVideoDecodeAV1ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeAV1ReferenceInfoFlags
    extends IPointer
    permits StdVideoDecodeAV1ReferenceInfoFlags, StdVideoDecodeAV1ReferenceInfoFlags.Ptr
{}

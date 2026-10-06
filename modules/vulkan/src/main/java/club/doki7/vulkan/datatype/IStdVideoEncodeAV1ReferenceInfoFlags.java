package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeAV1ReferenceInfoFlags} and {@link StdVideoEncodeAV1ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeAV1ReferenceInfoFlags
    extends IPointer
    permits StdVideoEncodeAV1ReferenceInfoFlags, StdVideoEncodeAV1ReferenceInfoFlags.Ptr
{}

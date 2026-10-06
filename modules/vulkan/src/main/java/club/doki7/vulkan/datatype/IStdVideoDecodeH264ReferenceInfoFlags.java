package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH264ReferenceInfoFlags} and {@link StdVideoDecodeH264ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH264ReferenceInfoFlags
    extends IPointer
    permits StdVideoDecodeH264ReferenceInfoFlags, StdVideoDecodeH264ReferenceInfoFlags.Ptr
{}

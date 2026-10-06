package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264ReferenceInfoFlags} and {@link StdVideoEncodeH264ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264ReferenceInfoFlags
    extends IPointer
    permits StdVideoEncodeH264ReferenceInfoFlags, StdVideoEncodeH264ReferenceInfoFlags.Ptr
{}

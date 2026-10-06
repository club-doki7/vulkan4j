package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH265ReferenceInfoFlags} and {@link StdVideoDecodeH265ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH265ReferenceInfoFlags
    extends IPointer
    permits StdVideoDecodeH265ReferenceInfoFlags, StdVideoDecodeH265ReferenceInfoFlags.Ptr
{}

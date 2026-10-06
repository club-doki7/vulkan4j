package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265ReferenceInfoFlags} and {@link StdVideoEncodeH265ReferenceInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265ReferenceInfoFlags
    extends IPointer
    permits StdVideoEncodeH265ReferenceInfoFlags, StdVideoEncodeH265ReferenceInfoFlags.Ptr
{}

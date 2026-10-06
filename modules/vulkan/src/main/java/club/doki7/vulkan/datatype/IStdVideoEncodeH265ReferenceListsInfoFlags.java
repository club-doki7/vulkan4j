package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH265ReferenceListsInfoFlags} and {@link StdVideoEncodeH265ReferenceListsInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH265ReferenceListsInfoFlags
    extends IPointer
    permits StdVideoEncodeH265ReferenceListsInfoFlags, StdVideoEncodeH265ReferenceListsInfoFlags.Ptr
{}

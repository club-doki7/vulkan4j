package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264ReferenceListsInfoFlags} and {@link StdVideoEncodeH264ReferenceListsInfoFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264ReferenceListsInfoFlags
    extends IPointer
    permits StdVideoEncodeH264ReferenceListsInfoFlags, StdVideoEncodeH264ReferenceListsInfoFlags.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1ColorConfigFlags} and {@link StdVideoAV1ColorConfigFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1ColorConfigFlags
    extends IPointer
    permits StdVideoAV1ColorConfigFlags, StdVideoAV1ColorConfigFlags.Ptr
{}

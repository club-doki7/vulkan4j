package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoAV1CDEF} and {@link StdVideoAV1CDEF.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoAV1CDEF
    extends IPointer
    permits StdVideoAV1CDEF, StdVideoAV1CDEF.Ptr
{}

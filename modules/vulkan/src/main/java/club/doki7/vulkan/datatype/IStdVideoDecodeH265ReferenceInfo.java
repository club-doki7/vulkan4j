package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoDecodeH265ReferenceInfo} and {@link StdVideoDecodeH265ReferenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoDecodeH265ReferenceInfo
    extends IPointer
    permits StdVideoDecodeH265ReferenceInfo, StdVideoDecodeH265ReferenceInfo.Ptr
{}

package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265DecPicBufMgr} and {@link StdVideoH265DecPicBufMgr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265DecPicBufMgr
    extends IPointer
    permits StdVideoH265DecPicBufMgr, StdVideoH265DecPicBufMgr.Ptr
{}

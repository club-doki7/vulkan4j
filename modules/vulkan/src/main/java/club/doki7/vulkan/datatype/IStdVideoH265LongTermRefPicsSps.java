package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265LongTermRefPicsSps} and {@link StdVideoH265LongTermRefPicsSps.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265LongTermRefPicsSps
    extends IPointer
    permits StdVideoH265LongTermRefPicsSps, StdVideoH265LongTermRefPicsSps.Ptr
{}

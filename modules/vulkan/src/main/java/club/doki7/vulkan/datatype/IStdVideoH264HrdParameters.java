package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264HrdParameters} and {@link StdVideoH264HrdParameters.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264HrdParameters
    extends IPointer
    permits StdVideoH264HrdParameters, StdVideoH264HrdParameters.Ptr
{}

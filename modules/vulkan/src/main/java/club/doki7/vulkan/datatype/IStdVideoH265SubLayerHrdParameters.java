package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265SubLayerHrdParameters} and {@link StdVideoH265SubLayerHrdParameters.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265SubLayerHrdParameters
    extends IPointer
    permits StdVideoH265SubLayerHrdParameters, StdVideoH265SubLayerHrdParameters.Ptr
{}

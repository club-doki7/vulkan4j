package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265PredictorPaletteEntries} and {@link StdVideoH265PredictorPaletteEntries.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265PredictorPaletteEntries
    extends IPointer
    permits StdVideoH265PredictorPaletteEntries, StdVideoH265PredictorPaletteEntries.Ptr
{}

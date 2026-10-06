package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShadingRatePaletteNV} and {@link VkShadingRatePaletteNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShadingRatePaletteNV
    extends IPointer
    permits VkShadingRatePaletteNV, VkShadingRatePaletteNV.Ptr
{}

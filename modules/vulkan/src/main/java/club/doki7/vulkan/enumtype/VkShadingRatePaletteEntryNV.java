package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShadingRatePaletteEntryNV.html"><code>VkShadingRatePaletteEntryNV</code></a>
public final class VkShadingRatePaletteEntryNV {
    public static final int NO_INVOCATIONS = 0x0;
    public static final int _16_INVOCATIONS_PER_PIXEL = 0x1;
    public static final int _8_INVOCATIONS_PER_PIXEL = 0x2;
    public static final int _4_INVOCATIONS_PER_PIXEL = 0x3;
    public static final int _2_INVOCATIONS_PER_PIXEL = 0x4;
    public static final int _1_INVOCATION_PER_PIXEL = 0x5;
    public static final int _1_INVOCATION_PER_2X1_PIXELS = 0x6;
    public static final int _1_INVOCATION_PER_1X2_PIXELS = 0x7;
    public static final int _1_INVOCATION_PER_2X2_PIXELS = 0x8;
    public static final int _1_INVOCATION_PER_4X2_PIXELS = 0x9;
    public static final int _1_INVOCATION_PER_2X4_PIXELS = 0xa;
    public static final int _1_INVOCATION_PER_4X4_PIXELS = 0xb;

    public static String explain(@EnumType(VkShadingRatePaletteEntryNV.class) int value) {
        return switch (value) {
            case VkShadingRatePaletteEntryNV._16_INVOCATIONS_PER_PIXEL -> "VK_SHADING_RATE_PALETTE_ENTRY_16_INVOCATIONS_PER_PIXEL_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_1X2_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_1X2_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_2X1_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_2X1_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_2X2_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_2X2_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_2X4_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_2X4_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_4X2_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_4X2_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_4X4_PIXELS -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_4X4_PIXELS_NV";
            case VkShadingRatePaletteEntryNV._1_INVOCATION_PER_PIXEL -> "VK_SHADING_RATE_PALETTE_ENTRY_1_INVOCATION_PER_PIXEL_NV";
            case VkShadingRatePaletteEntryNV._2_INVOCATIONS_PER_PIXEL -> "VK_SHADING_RATE_PALETTE_ENTRY_2_INVOCATIONS_PER_PIXEL_NV";
            case VkShadingRatePaletteEntryNV._4_INVOCATIONS_PER_PIXEL -> "VK_SHADING_RATE_PALETTE_ENTRY_4_INVOCATIONS_PER_PIXEL_NV";
            case VkShadingRatePaletteEntryNV._8_INVOCATIONS_PER_PIXEL -> "VK_SHADING_RATE_PALETTE_ENTRY_8_INVOCATIONS_PER_PIXEL_NV";
            case VkShadingRatePaletteEntryNV.NO_INVOCATIONS -> "VK_SHADING_RATE_PALETTE_ENTRY_NO_INVOCATIONS_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkShadingRatePaletteEntryNV() {}
}

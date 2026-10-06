package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFragmentShadingRateNV.html"><code>VkFragmentShadingRateNV</code></a>
public final class VkFragmentShadingRateNV {
    public static final int _1_INVOCATION_PER_PIXEL = 0x0;
    public static final int _1_INVOCATION_PER_1X2_PIXELS = 0x1;
    public static final int _1_INVOCATION_PER_2X1_PIXELS = 0x4;
    public static final int _1_INVOCATION_PER_2X2_PIXELS = 0x5;
    public static final int _1_INVOCATION_PER_2X4_PIXELS = 0x6;
    public static final int _1_INVOCATION_PER_4X2_PIXELS = 0x9;
    public static final int _1_INVOCATION_PER_4X4_PIXELS = 0xa;
    public static final int _2_INVOCATIONS_PER_PIXEL = 0xb;
    public static final int _4_INVOCATIONS_PER_PIXEL = 0xc;
    public static final int _8_INVOCATIONS_PER_PIXEL = 0xd;
    public static final int _16_INVOCATIONS_PER_PIXEL = 0xe;
    public static final int NO_INVOCATIONS = 0xf;

    public static String explain(@EnumType(VkFragmentShadingRateNV.class) int value) {
        return switch (value) {
            case VkFragmentShadingRateNV._16_INVOCATIONS_PER_PIXEL -> "VK_FRAGMENT_SHADING_RATE_16_INVOCATIONS_PER_PIXEL_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_1X2_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_1X2_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_2X1_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_2X1_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_2X2_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_2X2_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_2X4_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_2X4_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_4X2_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_4X2_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_4X4_PIXELS -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_4X4_PIXELS_NV";
            case VkFragmentShadingRateNV._1_INVOCATION_PER_PIXEL -> "VK_FRAGMENT_SHADING_RATE_1_INVOCATION_PER_PIXEL_NV";
            case VkFragmentShadingRateNV._2_INVOCATIONS_PER_PIXEL -> "VK_FRAGMENT_SHADING_RATE_2_INVOCATIONS_PER_PIXEL_NV";
            case VkFragmentShadingRateNV._4_INVOCATIONS_PER_PIXEL -> "VK_FRAGMENT_SHADING_RATE_4_INVOCATIONS_PER_PIXEL_NV";
            case VkFragmentShadingRateNV._8_INVOCATIONS_PER_PIXEL -> "VK_FRAGMENT_SHADING_RATE_8_INVOCATIONS_PER_PIXEL_NV";
            case VkFragmentShadingRateNV.NO_INVOCATIONS -> "VK_FRAGMENT_SHADING_RATE_NO_INVOCATIONS_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFragmentShadingRateNV() {}
}

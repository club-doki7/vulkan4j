package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlendOp.html"><code>VkBlendOp</code></a>
public final class VkBlendOp {
    public static final int ADD = 0x0;
    public static final int SUBTRACT = 0x1;
    public static final int REVERSE_SUBTRACT = 0x2;
    public static final int MIN = 0x3;
    public static final int MAX = 0x4;
    public static final int ZERO_EXT = 0x3b9d0c20;
    public static final int SRC_EXT = 0x3b9d0c21;
    public static final int DST_EXT = 0x3b9d0c22;
    public static final int SRC_OVER_EXT = 0x3b9d0c23;
    public static final int DST_OVER_EXT = 0x3b9d0c24;
    public static final int SRC_IN_EXT = 0x3b9d0c25;
    public static final int DST_IN_EXT = 0x3b9d0c26;
    public static final int SRC_OUT_EXT = 0x3b9d0c27;
    public static final int DST_OUT_EXT = 0x3b9d0c28;
    public static final int SRC_ATOP_EXT = 0x3b9d0c29;
    public static final int DST_ATOP_EXT = 0x3b9d0c2a;
    public static final int XOR_EXT = 0x3b9d0c2b;
    public static final int MULTIPLY_EXT = 0x3b9d0c2c;
    public static final int SCREEN_EXT = 0x3b9d0c2d;
    public static final int OVERLAY_EXT = 0x3b9d0c2e;
    public static final int DARKEN_EXT = 0x3b9d0c2f;
    public static final int LIGHTEN_EXT = 0x3b9d0c30;
    public static final int COLORDODGE_EXT = 0x3b9d0c31;
    public static final int COLORBURN_EXT = 0x3b9d0c32;
    public static final int HARDLIGHT_EXT = 0x3b9d0c33;
    public static final int SOFTLIGHT_EXT = 0x3b9d0c34;
    public static final int DIFFERENCE_EXT = 0x3b9d0c35;
    public static final int EXCLUSION_EXT = 0x3b9d0c36;
    public static final int INVERT_EXT = 0x3b9d0c37;
    public static final int INVERT_RGB_EXT = 0x3b9d0c38;
    public static final int LINEARDODGE_EXT = 0x3b9d0c39;
    public static final int LINEARBURN_EXT = 0x3b9d0c3a;
    public static final int VIVIDLIGHT_EXT = 0x3b9d0c3b;
    public static final int LINEARLIGHT_EXT = 0x3b9d0c3c;
    public static final int PINLIGHT_EXT = 0x3b9d0c3d;
    public static final int HARDMIX_EXT = 0x3b9d0c3e;
    public static final int HSL_HUE_EXT = 0x3b9d0c3f;
    public static final int HSL_SATURATION_EXT = 0x3b9d0c40;
    public static final int HSL_COLOR_EXT = 0x3b9d0c41;
    public static final int HSL_LUMINOSITY_EXT = 0x3b9d0c42;
    public static final int PLUS_EXT = 0x3b9d0c43;
    public static final int PLUS_CLAMPED_EXT = 0x3b9d0c44;
    public static final int PLUS_CLAMPED_ALPHA_EXT = 0x3b9d0c45;
    public static final int PLUS_DARKER_EXT = 0x3b9d0c46;
    public static final int MINUS_EXT = 0x3b9d0c47;
    public static final int MINUS_CLAMPED_EXT = 0x3b9d0c48;
    public static final int CONTRAST_EXT = 0x3b9d0c49;
    public static final int INVERT_OVG_EXT = 0x3b9d0c4a;
    public static final int RED_EXT = 0x3b9d0c4b;
    public static final int GREEN_EXT = 0x3b9d0c4c;
    public static final int BLUE_EXT = 0x3b9d0c4d;

    public static String explain(@EnumType(VkBlendOp.class) int value) {
        return switch (value) {
            case VkBlendOp.ADD -> "VK_BLEND_OP_ADD";
            case VkBlendOp.BLUE_EXT -> "VK_BLEND_OP_BLUE_EXT";
            case VkBlendOp.COLORBURN_EXT -> "VK_BLEND_OP_COLORBURN_EXT";
            case VkBlendOp.COLORDODGE_EXT -> "VK_BLEND_OP_COLORDODGE_EXT";
            case VkBlendOp.CONTRAST_EXT -> "VK_BLEND_OP_CONTRAST_EXT";
            case VkBlendOp.DARKEN_EXT -> "VK_BLEND_OP_DARKEN_EXT";
            case VkBlendOp.DIFFERENCE_EXT -> "VK_BLEND_OP_DIFFERENCE_EXT";
            case VkBlendOp.DST_ATOP_EXT -> "VK_BLEND_OP_DST_ATOP_EXT";
            case VkBlendOp.DST_EXT -> "VK_BLEND_OP_DST_EXT";
            case VkBlendOp.DST_IN_EXT -> "VK_BLEND_OP_DST_IN_EXT";
            case VkBlendOp.DST_OUT_EXT -> "VK_BLEND_OP_DST_OUT_EXT";
            case VkBlendOp.DST_OVER_EXT -> "VK_BLEND_OP_DST_OVER_EXT";
            case VkBlendOp.EXCLUSION_EXT -> "VK_BLEND_OP_EXCLUSION_EXT";
            case VkBlendOp.GREEN_EXT -> "VK_BLEND_OP_GREEN_EXT";
            case VkBlendOp.HARDLIGHT_EXT -> "VK_BLEND_OP_HARDLIGHT_EXT";
            case VkBlendOp.HARDMIX_EXT -> "VK_BLEND_OP_HARDMIX_EXT";
            case VkBlendOp.HSL_COLOR_EXT -> "VK_BLEND_OP_HSL_COLOR_EXT";
            case VkBlendOp.HSL_HUE_EXT -> "VK_BLEND_OP_HSL_HUE_EXT";
            case VkBlendOp.HSL_LUMINOSITY_EXT -> "VK_BLEND_OP_HSL_LUMINOSITY_EXT";
            case VkBlendOp.HSL_SATURATION_EXT -> "VK_BLEND_OP_HSL_SATURATION_EXT";
            case VkBlendOp.INVERT_EXT -> "VK_BLEND_OP_INVERT_EXT";
            case VkBlendOp.INVERT_OVG_EXT -> "VK_BLEND_OP_INVERT_OVG_EXT";
            case VkBlendOp.INVERT_RGB_EXT -> "VK_BLEND_OP_INVERT_RGB_EXT";
            case VkBlendOp.LIGHTEN_EXT -> "VK_BLEND_OP_LIGHTEN_EXT";
            case VkBlendOp.LINEARBURN_EXT -> "VK_BLEND_OP_LINEARBURN_EXT";
            case VkBlendOp.LINEARDODGE_EXT -> "VK_BLEND_OP_LINEARDODGE_EXT";
            case VkBlendOp.LINEARLIGHT_EXT -> "VK_BLEND_OP_LINEARLIGHT_EXT";
            case VkBlendOp.MAX -> "VK_BLEND_OP_MAX";
            case VkBlendOp.MIN -> "VK_BLEND_OP_MIN";
            case VkBlendOp.MINUS_CLAMPED_EXT -> "VK_BLEND_OP_MINUS_CLAMPED_EXT";
            case VkBlendOp.MINUS_EXT -> "VK_BLEND_OP_MINUS_EXT";
            case VkBlendOp.MULTIPLY_EXT -> "VK_BLEND_OP_MULTIPLY_EXT";
            case VkBlendOp.OVERLAY_EXT -> "VK_BLEND_OP_OVERLAY_EXT";
            case VkBlendOp.PINLIGHT_EXT -> "VK_BLEND_OP_PINLIGHT_EXT";
            case VkBlendOp.PLUS_CLAMPED_ALPHA_EXT -> "VK_BLEND_OP_PLUS_CLAMPED_ALPHA_EXT";
            case VkBlendOp.PLUS_CLAMPED_EXT -> "VK_BLEND_OP_PLUS_CLAMPED_EXT";
            case VkBlendOp.PLUS_DARKER_EXT -> "VK_BLEND_OP_PLUS_DARKER_EXT";
            case VkBlendOp.PLUS_EXT -> "VK_BLEND_OP_PLUS_EXT";
            case VkBlendOp.RED_EXT -> "VK_BLEND_OP_RED_EXT";
            case VkBlendOp.REVERSE_SUBTRACT -> "VK_BLEND_OP_REVERSE_SUBTRACT";
            case VkBlendOp.SCREEN_EXT -> "VK_BLEND_OP_SCREEN_EXT";
            case VkBlendOp.SOFTLIGHT_EXT -> "VK_BLEND_OP_SOFTLIGHT_EXT";
            case VkBlendOp.SRC_ATOP_EXT -> "VK_BLEND_OP_SRC_ATOP_EXT";
            case VkBlendOp.SRC_EXT -> "VK_BLEND_OP_SRC_EXT";
            case VkBlendOp.SRC_IN_EXT -> "VK_BLEND_OP_SRC_IN_EXT";
            case VkBlendOp.SRC_OUT_EXT -> "VK_BLEND_OP_SRC_OUT_EXT";
            case VkBlendOp.SRC_OVER_EXT -> "VK_BLEND_OP_SRC_OVER_EXT";
            case VkBlendOp.SUBTRACT -> "VK_BLEND_OP_SUBTRACT";
            case VkBlendOp.VIVIDLIGHT_EXT -> "VK_BLEND_OP_VIVIDLIGHT_EXT";
            case VkBlendOp.XOR_EXT -> "VK_BLEND_OP_XOR_EXT";
            case VkBlendOp.ZERO_EXT -> "VK_BLEND_OP_ZERO_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBlendOp() {}
}

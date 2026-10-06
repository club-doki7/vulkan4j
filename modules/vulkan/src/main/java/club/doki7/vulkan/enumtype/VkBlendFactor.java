package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlendFactor.html"><code>VkBlendFactor</code></a>
public final class VkBlendFactor {
    public static final int ZERO = 0x0;
    public static final int ONE = 0x1;
    public static final int SRC_COLOR = 0x2;
    public static final int ONE_MINUS_SRC_COLOR = 0x3;
    public static final int DST_COLOR = 0x4;
    public static final int ONE_MINUS_DST_COLOR = 0x5;
    public static final int SRC_ALPHA = 0x6;
    public static final int ONE_MINUS_SRC_ALPHA = 0x7;
    public static final int DST_ALPHA = 0x8;
    public static final int ONE_MINUS_DST_ALPHA = 0x9;
    public static final int CONSTANT_COLOR = 0xa;
    public static final int ONE_MINUS_CONSTANT_COLOR = 0xb;
    public static final int CONSTANT_ALPHA = 0xc;
    public static final int ONE_MINUS_CONSTANT_ALPHA = 0xd;
    public static final int SRC_ALPHA_SATURATE = 0xe;
    public static final int SRC1_COLOR = 0xf;
    public static final int ONE_MINUS_SRC1_COLOR = 0x10;
    public static final int SRC1_ALPHA = 0x11;
    public static final int ONE_MINUS_SRC1_ALPHA = 0x12;

    public static String explain(@EnumType(VkBlendFactor.class) int value) {
        return switch (value) {
            case VkBlendFactor.CONSTANT_ALPHA -> "VK_BLEND_FACTOR_CONSTANT_ALPHA";
            case VkBlendFactor.CONSTANT_COLOR -> "VK_BLEND_FACTOR_CONSTANT_COLOR";
            case VkBlendFactor.DST_ALPHA -> "VK_BLEND_FACTOR_DST_ALPHA";
            case VkBlendFactor.DST_COLOR -> "VK_BLEND_FACTOR_DST_COLOR";
            case VkBlendFactor.ONE -> "VK_BLEND_FACTOR_ONE";
            case VkBlendFactor.ONE_MINUS_CONSTANT_ALPHA -> "VK_BLEND_FACTOR_ONE_MINUS_CONSTANT_ALPHA";
            case VkBlendFactor.ONE_MINUS_CONSTANT_COLOR -> "VK_BLEND_FACTOR_ONE_MINUS_CONSTANT_COLOR";
            case VkBlendFactor.ONE_MINUS_DST_ALPHA -> "VK_BLEND_FACTOR_ONE_MINUS_DST_ALPHA";
            case VkBlendFactor.ONE_MINUS_DST_COLOR -> "VK_BLEND_FACTOR_ONE_MINUS_DST_COLOR";
            case VkBlendFactor.ONE_MINUS_SRC1_ALPHA -> "VK_BLEND_FACTOR_ONE_MINUS_SRC1_ALPHA";
            case VkBlendFactor.ONE_MINUS_SRC1_COLOR -> "VK_BLEND_FACTOR_ONE_MINUS_SRC1_COLOR";
            case VkBlendFactor.ONE_MINUS_SRC_ALPHA -> "VK_BLEND_FACTOR_ONE_MINUS_SRC_ALPHA";
            case VkBlendFactor.ONE_MINUS_SRC_COLOR -> "VK_BLEND_FACTOR_ONE_MINUS_SRC_COLOR";
            case VkBlendFactor.SRC1_ALPHA -> "VK_BLEND_FACTOR_SRC1_ALPHA";
            case VkBlendFactor.SRC1_COLOR -> "VK_BLEND_FACTOR_SRC1_COLOR";
            case VkBlendFactor.SRC_ALPHA -> "VK_BLEND_FACTOR_SRC_ALPHA";
            case VkBlendFactor.SRC_ALPHA_SATURATE -> "VK_BLEND_FACTOR_SRC_ALPHA_SATURATE";
            case VkBlendFactor.SRC_COLOR -> "VK_BLEND_FACTOR_SRC_COLOR";
            case VkBlendFactor.ZERO -> "VK_BLEND_FACTOR_ZERO";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBlendFactor() {}
}

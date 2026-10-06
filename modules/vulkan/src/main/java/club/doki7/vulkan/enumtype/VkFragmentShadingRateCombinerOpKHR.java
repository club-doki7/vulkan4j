package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFragmentShadingRateCombinerOpKHR.html"><code>VkFragmentShadingRateCombinerOpKHR</code></a>
public final class VkFragmentShadingRateCombinerOpKHR {
    public static final int KEEP = 0x0;
    public static final int REPLACE = 0x1;
    public static final int MIN = 0x2;
    public static final int MAX = 0x3;
    public static final int MUL = 0x4;

    public static String explain(@EnumType(VkFragmentShadingRateCombinerOpKHR.class) int value) {
        return switch (value) {
            case VkFragmentShadingRateCombinerOpKHR.KEEP -> "VK_FRAGMENT_SHADING_RATE_COMBINER_OP_KEEP_KHR";
            case VkFragmentShadingRateCombinerOpKHR.MAX -> "VK_FRAGMENT_SHADING_RATE_COMBINER_OP_MAX_KHR";
            case VkFragmentShadingRateCombinerOpKHR.MIN -> "VK_FRAGMENT_SHADING_RATE_COMBINER_OP_MIN_KHR";
            case VkFragmentShadingRateCombinerOpKHR.MUL -> "VK_FRAGMENT_SHADING_RATE_COMBINER_OP_MUL_KHR";
            case VkFragmentShadingRateCombinerOpKHR.REPLACE -> "VK_FRAGMENT_SHADING_RATE_COMBINER_OP_REPLACE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFragmentShadingRateCombinerOpKHR() {}
}

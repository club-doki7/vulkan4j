package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerReductionMode.html"><code>VkSamplerReductionMode</code></a>
public final class VkSamplerReductionMode {
    public static final int WEIGHTED_AVERAGE = 0x0;
    public static final int MIN = 0x1;
    public static final int MAX = 0x2;
    public static final int WEIGHTED_AVERAGE_RANGECLAMP_QCOM = 0x3ba2bd28;

    public static String explain(@EnumType(VkSamplerReductionMode.class) int value) {
        return switch (value) {
            case VkSamplerReductionMode.MAX -> "VK_SAMPLER_REDUCTION_MODE_MAX";
            case VkSamplerReductionMode.MIN -> "VK_SAMPLER_REDUCTION_MODE_MIN";
            case VkSamplerReductionMode.WEIGHTED_AVERAGE -> "VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE";
            case VkSamplerReductionMode.WEIGHTED_AVERAGE_RANGECLAMP_QCOM -> "VK_SAMPLER_REDUCTION_MODE_WEIGHTED_AVERAGE_RANGECLAMP_QCOM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerReductionMode() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerfHintTypeQCOM.html"><code>VkPerfHintTypeQCOM</code></a>
public final class VkPerfHintTypeQCOM {
    public static final int DEFAULT = 0x0;
    public static final int FREQUENCY_MIN = 0x1;
    public static final int FREQUENCY_MAX = 0x2;
    public static final int FREQUENCY_SCALED = 0x3;

    public static String explain(@EnumType(VkPerfHintTypeQCOM.class) int value) {
        return switch (value) {
            case VkPerfHintTypeQCOM.DEFAULT -> "VK_PERF_HINT_TYPE_DEFAULT_QCOM";
            case VkPerfHintTypeQCOM.FREQUENCY_MAX -> "VK_PERF_HINT_TYPE_FREQUENCY_MAX_QCOM";
            case VkPerfHintTypeQCOM.FREQUENCY_MIN -> "VK_PERF_HINT_TYPE_FREQUENCY_MIN_QCOM";
            case VkPerfHintTypeQCOM.FREQUENCY_SCALED -> "VK_PERF_HINT_TYPE_FREQUENCY_SCALED_QCOM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerfHintTypeQCOM() {}
}

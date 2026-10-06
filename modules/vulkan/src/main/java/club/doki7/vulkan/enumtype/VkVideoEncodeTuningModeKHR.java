package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeTuningModeKHR.html"><code>VkVideoEncodeTuningModeKHR</code></a>
public final class VkVideoEncodeTuningModeKHR {
    public static final int DEFAULT = 0x0;
    public static final int HIGH_QUALITY = 0x1;
    public static final int LOW_LATENCY = 0x2;
    public static final int ULTRA_LOW_LATENCY = 0x3;
    public static final int LOSSLESS = 0x4;

    public static String explain(@EnumType(VkVideoEncodeTuningModeKHR.class) int value) {
        return switch (value) {
            case VkVideoEncodeTuningModeKHR.DEFAULT -> "VK_VIDEO_ENCODE_TUNING_MODE_DEFAULT_KHR";
            case VkVideoEncodeTuningModeKHR.HIGH_QUALITY -> "VK_VIDEO_ENCODE_TUNING_MODE_HIGH_QUALITY_KHR";
            case VkVideoEncodeTuningModeKHR.LOSSLESS -> "VK_VIDEO_ENCODE_TUNING_MODE_LOSSLESS_KHR";
            case VkVideoEncodeTuningModeKHR.LOW_LATENCY -> "VK_VIDEO_ENCODE_TUNING_MODE_LOW_LATENCY_KHR";
            case VkVideoEncodeTuningModeKHR.ULTRA_LOW_LATENCY -> "VK_VIDEO_ENCODE_TUNING_MODE_ULTRA_LOW_LATENCY_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeTuningModeKHR() {}
}

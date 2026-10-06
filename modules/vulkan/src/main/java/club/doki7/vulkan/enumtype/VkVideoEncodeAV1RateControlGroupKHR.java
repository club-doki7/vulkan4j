package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1RateControlGroupKHR.html"><code>VkVideoEncodeAV1RateControlGroupKHR</code></a>
public final class VkVideoEncodeAV1RateControlGroupKHR {
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_INTRA = 0x0;
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_PREDICTIVE = 0x1;
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_BIPREDICTIVE = 0x2;

    public static String explain(@EnumType(VkVideoEncodeAV1RateControlGroupKHR.class) int value) {
        return switch (value) {
            case VkVideoEncodeAV1RateControlGroupKHR.VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_BIPREDICTIVE -> "VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_BIPREDICTIVE_KHR";
            case VkVideoEncodeAV1RateControlGroupKHR.VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_INTRA -> "VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_INTRA_KHR";
            case VkVideoEncodeAV1RateControlGroupKHR.VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_PREDICTIVE -> "VK_VIDEO_ENCODE_AV1_RATE_CONTROL_GROUP_PREDICTIVE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1RateControlGroupKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1RateControlFlagsKHR.html"><code>VkVideoEncodeAV1RateControlFlagsKHR</code></a>
public final class VkVideoEncodeAV1RateControlFlagsKHR {
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_DYADIC = 0x8;
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_FLAT = 0x4;
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REGULAR_GOP = 0x1;
    public static final int VK_VIDEO_ENCODE_AV1_RATE_CONTROL_TEMPORAL_LAYER_PATTERN_DYADIC = 0x2;

    public static String explain(@Bitmask(VkVideoEncodeAV1RateControlFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_DYADIC) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_DYADIC_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_FLAT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REFERENCE_PATTERN_FLAT_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REGULAR_GOP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_RATE_CONTROL_REGULAR_GOP_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_RATE_CONTROL_TEMPORAL_LAYER_PATTERN_DYADIC) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_RATE_CONTROL_TEMPORAL_LAYER_PATTERN_DYADIC_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1RateControlFlagsKHR() {}
}

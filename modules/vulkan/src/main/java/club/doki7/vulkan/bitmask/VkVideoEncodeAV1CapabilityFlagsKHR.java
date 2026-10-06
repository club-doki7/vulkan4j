package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1CapabilityFlagsKHR.html"><code>VkVideoEncodeAV1CapabilityFlagsKHR</code></a>
public final class VkVideoEncodeAV1CapabilityFlagsKHR {
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_COMPOUND_PREDICTION_INTRA_REFRESH = 0x20;
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_FRAME_SIZE_OVERRIDE = 0x8;
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_GENERATE_OBU_EXTENSION_HEADER = 0x2;
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_MOTION_VECTOR_SCALING = 0x10;
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_PER_RATE_CONTROL_GROUP_MIN_MAX_Q_INDEX = 0x1;
    public static final int VK_VIDEO_ENCODE_AV1_CAPABILITY_PRIMARY_REFERENCE_CDF_ONLY = 0x4;

    public static String explain(@Bitmask(VkVideoEncodeAV1CapabilityFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_COMPOUND_PREDICTION_INTRA_REFRESH) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_COMPOUND_PREDICTION_INTRA_REFRESH_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_FRAME_SIZE_OVERRIDE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_FRAME_SIZE_OVERRIDE_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_GENERATE_OBU_EXTENSION_HEADER) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_GENERATE_OBU_EXTENSION_HEADER_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_MOTION_VECTOR_SCALING) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_MOTION_VECTOR_SCALING_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_PER_RATE_CONTROL_GROUP_MIN_MAX_Q_INDEX) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_PER_RATE_CONTROL_GROUP_MIN_MAX_Q_INDEX_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_CAPABILITY_PRIMARY_REFERENCE_CDF_ONLY) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_CAPABILITY_PRIMARY_REFERENCE_CDF_ONLY_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1CapabilityFlagsKHR() {}
}

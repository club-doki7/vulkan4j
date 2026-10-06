package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1StdFlagsKHR.html"><code>VkVideoEncodeAV1StdFlagsKHR</code></a>
public final class VkVideoEncodeAV1StdFlagsKHR {
    public static final int VK_VIDEO_ENCODE_AV1_STD_DELTA_Q = 0x8;
    public static final int VK_VIDEO_ENCODE_AV1_STD_PRIMARY_REF_FRAME = 0x4;
    public static final int VK_VIDEO_ENCODE_AV1_STD_SKIP_MODE_PRESENT_UNSET = 0x2;
    public static final int VK_VIDEO_ENCODE_AV1_STD_UNIFORM_TILE_SPACING_FLAG_SET = 0x1;

    public static String explain(@Bitmask(VkVideoEncodeAV1StdFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_AV1_STD_DELTA_Q) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_STD_DELTA_Q_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_STD_PRIMARY_REF_FRAME) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_STD_PRIMARY_REF_FRAME_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_STD_SKIP_MODE_PRESENT_UNSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_STD_SKIP_MODE_PRESENT_UNSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_STD_UNIFORM_TILE_SPACING_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_STD_UNIFORM_TILE_SPACING_FLAG_SET_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1StdFlagsKHR() {}
}

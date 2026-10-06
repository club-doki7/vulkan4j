package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCodingControlFlagsKHR.html"><code>VkVideoCodingControlFlagsKHR</code></a>
public final class VkVideoCodingControlFlagsKHR {
    public static final int ENCODE_QUALITY_LEVEL = 0x4;
    public static final int ENCODE_RATE_CONTROL = 0x2;
    public static final int RESET = 0x1;

    public static String explain(@Bitmask(VkVideoCodingControlFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ENCODE_QUALITY_LEVEL) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODING_CONTROL_ENCODE_QUALITY_LEVEL_BIT_KHR");
        }
        if ((flags & ENCODE_RATE_CONTROL) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODING_CONTROL_ENCODE_RATE_CONTROL_BIT_KHR");
        }
        if ((flags & RESET) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODING_CONTROL_RESET_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoCodingControlFlagsKHR() {}
}

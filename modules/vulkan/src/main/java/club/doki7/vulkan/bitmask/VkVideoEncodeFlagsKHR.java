package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeFlagsKHR.html"><code>VkVideoEncodeFlagsKHR</code></a>
public final class VkVideoEncodeFlagsKHR {
    public static final int INTRA_REFRESH = 0x4;
    public static final int WITH_EMPHASIS_MAP = 0x2;
    public static final int WITH_QUANTIZATION_DELTA_MAP = 0x1;

    public static String explain(@Bitmask(VkVideoEncodeFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INTRA_REFRESH) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_BIT_KHR");
        }
        if ((flags & WITH_EMPHASIS_MAP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_WITH_EMPHASIS_MAP_BIT_KHR");
        }
        if ((flags & WITH_QUANTIZATION_DELTA_MAP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_WITH_QUANTIZATION_DELTA_MAP_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeFlagsKHR() {}
}

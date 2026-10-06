package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeUsageFlagsKHR.html"><code>VkVideoDecodeUsageFlagsKHR</code></a>
public final class VkVideoDecodeUsageFlagsKHR {
    public static final int DEFAULT = 0x0;
    public static final int OFFLINE = 0x2;
    public static final int STREAMING = 0x4;
    public static final int TRANSCODING = 0x1;

    public static String explain(@Bitmask(VkVideoDecodeUsageFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEFAULT) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_USAGE_DEFAULT_KHR");
        }
        if ((flags & OFFLINE) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_USAGE_OFFLINE_BIT_KHR");
        }
        if ((flags & STREAMING) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_USAGE_STREAMING_BIT_KHR");
        }
        if ((flags & TRANSCODING) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_USAGE_TRANSCODING_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoDecodeUsageFlagsKHR() {}
}

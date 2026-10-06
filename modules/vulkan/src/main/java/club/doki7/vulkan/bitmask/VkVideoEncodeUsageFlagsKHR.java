package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeUsageFlagsKHR.html"><code>VkVideoEncodeUsageFlagsKHR</code></a>
public final class VkVideoEncodeUsageFlagsKHR {
    public static final int CONFERENCING = 0x8;
    public static final int DEFAULT = 0x0;
    public static final int RECORDING = 0x4;
    public static final int STREAMING = 0x2;
    public static final int TRANSCODING = 0x1;

    public static String explain(@Bitmask(VkVideoEncodeUsageFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CONFERENCING) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_USAGE_CONFERENCING_BIT_KHR");
        }
        if ((flags & DEFAULT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_USAGE_DEFAULT_KHR");
        }
        if ((flags & RECORDING) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_USAGE_RECORDING_BIT_KHR");
        }
        if ((flags & STREAMING) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_USAGE_STREAMING_BIT_KHR");
        }
        if ((flags & TRANSCODING) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_USAGE_TRANSCODING_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeUsageFlagsKHR() {}
}

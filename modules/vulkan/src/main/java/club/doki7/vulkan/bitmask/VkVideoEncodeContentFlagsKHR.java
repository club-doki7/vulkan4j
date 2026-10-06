package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeContentFlagsKHR.html"><code>VkVideoEncodeContentFlagsKHR</code></a>
public final class VkVideoEncodeContentFlagsKHR {
    public static final int CAMERA = 0x1;
    public static final int DEFAULT = 0x0;
    public static final int DESKTOP = 0x2;
    public static final int RENDERED = 0x4;

    public static String explain(@Bitmask(VkVideoEncodeContentFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CAMERA) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_CONTENT_CAMERA_BIT_KHR");
        }
        if ((flags & DEFAULT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_CONTENT_DEFAULT_KHR");
        }
        if ((flags & DESKTOP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_CONTENT_DESKTOP_BIT_KHR");
        }
        if ((flags & RENDERED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_CONTENT_RENDERED_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeContentFlagsKHR() {}
}

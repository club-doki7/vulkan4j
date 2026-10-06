package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoComponentBitDepthFlagsKHR.html"><code>VkVideoComponentBitDepthFlagsKHR</code></a>
public final class VkVideoComponentBitDepthFlagsKHR {
    public static final int _10 = 0x4;
    public static final int _12 = 0x10;
    public static final int _8 = 0x1;
    public static final int INVALID = 0x0;

    public static String explain(@Bitmask(VkVideoComponentBitDepthFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _10) != 0) {
            detectedFlagBits.add("VK_VIDEO_COMPONENT_BIT_DEPTH_10_BIT_KHR");
        }
        if ((flags & _12) != 0) {
            detectedFlagBits.add("VK_VIDEO_COMPONENT_BIT_DEPTH_12_BIT_KHR");
        }
        if ((flags & _8) != 0) {
            detectedFlagBits.add("VK_VIDEO_COMPONENT_BIT_DEPTH_8_BIT_KHR");
        }
        if ((flags & INVALID) != 0) {
            detectedFlagBits.add("VK_VIDEO_COMPONENT_BIT_DEPTH_INVALID_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoComponentBitDepthFlagsKHR() {}
}

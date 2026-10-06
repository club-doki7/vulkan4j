package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingInfoFlagsEXT.html"><code>VkPresentTimingInfoFlagsEXT</code></a>
public final class VkPresentTimingInfoFlagsEXT {
    public static final int PRESENT_AT_NEAREST_REFRESH_CYCLE = 0x2;
    public static final int PRESENT_AT_RELATIVE_TIME = 0x1;

    public static String explain(@Bitmask(VkPresentTimingInfoFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PRESENT_AT_NEAREST_REFRESH_CYCLE) != 0) {
            detectedFlagBits.add("VK_PRESENT_TIMING_INFO_PRESENT_AT_NEAREST_REFRESH_CYCLE_BIT_EXT");
        }
        if ((flags & PRESENT_AT_RELATIVE_TIME) != 0) {
            detectedFlagBits.add("VK_PRESENT_TIMING_INFO_PRESENT_AT_RELATIVE_TIME_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPresentTimingInfoFlagsEXT() {}
}

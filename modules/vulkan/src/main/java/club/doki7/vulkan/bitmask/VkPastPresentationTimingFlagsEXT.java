package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingFlagsEXT.html"><code>VkPastPresentationTimingFlagsEXT</code></a>
public final class VkPastPresentationTimingFlagsEXT {
    public static final int ALLOW_OUT_OF_ORDER_RESULTS = 0x2;
    public static final int ALLOW_PARTIAL_RESULTS = 0x1;

    public static String explain(@Bitmask(VkPastPresentationTimingFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_OUT_OF_ORDER_RESULTS) != 0) {
            detectedFlagBits.add("VK_PAST_PRESENTATION_TIMING_ALLOW_OUT_OF_ORDER_RESULTS_BIT_EXT");
        }
        if ((flags & ALLOW_PARTIAL_RESULTS) != 0) {
            detectedFlagBits.add("VK_PAST_PRESENTATION_TIMING_ALLOW_PARTIAL_RESULTS_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPastPresentationTimingFlagsEXT() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterDescriptionFlagsKHR.html"><code>VkPerformanceCounterDescriptionFlagsKHR</code></a>
public final class VkPerformanceCounterDescriptionFlagsKHR {
    public static final int CONCURRENTLY_IMPACTED = 0x2;
    public static final int PERFORMANCE_IMPACTING = 0x1;

    public static String explain(@Bitmask(VkPerformanceCounterDescriptionFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CONCURRENTLY_IMPACTED) != 0) {
            detectedFlagBits.add("VK_PERFORMANCE_COUNTER_DESCRIPTION_CONCURRENTLY_IMPACTED_BIT_KHR");
        }
        if ((flags & PERFORMANCE_IMPACTING) != 0) {
            detectedFlagBits.add("VK_PERFORMANCE_COUNTER_DESCRIPTION_PERFORMANCE_IMPACTING_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceCounterDescriptionFlagsKHR() {}
}

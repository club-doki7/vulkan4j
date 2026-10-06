package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryResultFlags.html"><code>VkQueryResultFlags</code></a>
public final class VkQueryResultFlags {
    public static final int _64 = 0x1;
    public static final int PARTIAL = 0x8;
    public static final int WAIT = 0x2;
    public static final int WITH_AVAILABILITY = 0x4;
    public static final int WITH_STATUS_KHR = 0x10;

    public static String explain(@Bitmask(VkQueryResultFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _64) != 0) {
            detectedFlagBits.add("VK_QUERY_RESULT_64_BIT");
        }
        if ((flags & PARTIAL) != 0) {
            detectedFlagBits.add("VK_QUERY_RESULT_PARTIAL_BIT");
        }
        if ((flags & WAIT) != 0) {
            detectedFlagBits.add("VK_QUERY_RESULT_WAIT_BIT");
        }
        if ((flags & WITH_AVAILABILITY) != 0) {
            detectedFlagBits.add("VK_QUERY_RESULT_WITH_AVAILABILITY_BIT");
        }
        if ((flags & WITH_STATUS_KHR) != 0) {
            detectedFlagBits.add("VK_QUERY_RESULT_WITH_STATUS_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryResultFlags() {}
}

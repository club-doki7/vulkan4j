package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryControlFlags.html"><code>VkQueryControlFlags</code></a>
public final class VkQueryControlFlags {
    public static final int PRECISE = 0x1;

    public static String explain(@Bitmask(VkQueryControlFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PRECISE) != 0) {
            detectedFlagBits.add("VK_QUERY_CONTROL_PRECISE_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryControlFlags() {}
}

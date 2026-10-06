package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryPoolCreateFlags.html"><code>VkQueryPoolCreateFlags</code></a>
public final class VkQueryPoolCreateFlags {
    public static final int RESET_KHR = 0x1;

    public static String explain(@Bitmask(VkQueryPoolCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RESET_KHR) != 0) {
            detectedFlagBits.add("VK_QUERY_POOL_CREATE_RESET_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryPoolCreateFlags() {}
}

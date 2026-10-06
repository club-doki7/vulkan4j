package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFenceCreateFlags.html"><code>VkFenceCreateFlags</code></a>
public final class VkFenceCreateFlags {
    public static final int SIGNALED = 0x1;

    public static String explain(@Bitmask(VkFenceCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & SIGNALED) != 0) {
            detectedFlagBits.add("VK_FENCE_CREATE_SIGNALED_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFenceCreateFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandPoolResetFlags.html"><code>VkCommandPoolResetFlags</code></a>
public final class VkCommandPoolResetFlags {
    public static final int RELEASE_RESOURCES = 0x1;

    public static String explain(@Bitmask(VkCommandPoolResetFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RELEASE_RESOURCES) != 0) {
            detectedFlagBits.add("VK_COMMAND_POOL_RESET_RELEASE_RESOURCES_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCommandPoolResetFlags() {}
}

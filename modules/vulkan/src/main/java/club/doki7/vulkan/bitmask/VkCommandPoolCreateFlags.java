package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandPoolCreateFlags.html"><code>VkCommandPoolCreateFlags</code></a>
public final class VkCommandPoolCreateFlags {
    public static final int PROTECTED = 0x4;
    public static final int RESET_COMMAND_BUFFER = 0x2;
    public static final int TRANSIENT = 0x1;

    public static String explain(@Bitmask(VkCommandPoolCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_COMMAND_POOL_CREATE_PROTECTED_BIT");
        }
        if ((flags & RESET_COMMAND_BUFFER) != 0) {
            detectedFlagBits.add("VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT");
        }
        if ((flags & TRANSIENT) != 0) {
            detectedFlagBits.add("VK_COMMAND_POOL_CREATE_TRANSIENT_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCommandPoolCreateFlags() {}
}

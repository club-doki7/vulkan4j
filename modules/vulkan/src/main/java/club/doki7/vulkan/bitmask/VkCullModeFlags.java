package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCullModeFlags.html"><code>VkCullModeFlags</code></a>
public final class VkCullModeFlags {
    public static final int BACK = 0x2;
    public static final int FRONT_AND_BACK = 0x3;
    public static final int FRONT = 0x1;
    public static final int NONE = 0x0;

    public static String explain(@Bitmask(VkCullModeFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & BACK) != 0) {
            detectedFlagBits.add("VK_CULL_MODE_BACK_BIT");
        }
        if ((flags & FRONT_AND_BACK) != 0) {
            detectedFlagBits.add("VK_CULL_MODE_FRONT_AND_BACK");
        }
        if ((flags & FRONT) != 0) {
            detectedFlagBits.add("VK_CULL_MODE_FRONT_BIT");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_CULL_MODE_NONE");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCullModeFlags() {}
}

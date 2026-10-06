package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryMapFlags.html"><code>VkMemoryMapFlags</code></a>
public final class VkMemoryMapFlags {
    public static final int PLACED_EXT = 0x1;

    public static String explain(@Bitmask(VkMemoryMapFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PLACED_EXT) != 0) {
            detectedFlagBits.add("VK_MEMORY_MAP_PLACED_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryMapFlags() {}
}

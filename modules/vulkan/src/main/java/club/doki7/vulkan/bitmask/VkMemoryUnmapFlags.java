package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryUnmapFlags.html"><code>VkMemoryUnmapFlags</code></a>
public final class VkMemoryUnmapFlags {
    public static final int RESERVE_EXT = 0x1;

    public static String explain(@Bitmask(VkMemoryUnmapFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RESERVE_EXT) != 0) {
            detectedFlagBits.add("VK_MEMORY_UNMAP_RESERVE_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryUnmapFlags() {}
}

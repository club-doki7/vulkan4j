package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryHeapFlags.html"><code>VkMemoryHeapFlags</code></a>
public final class VkMemoryHeapFlags {
    public static final int DEVICE_LOCAL = 0x1;
    public static final int MULTI_INSTANCE = 0x2;
    public static final int TILE_MEMORY_QCOM = 0x8;

    public static String explain(@Bitmask(VkMemoryHeapFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_LOCAL) != 0) {
            detectedFlagBits.add("VK_MEMORY_HEAP_DEVICE_LOCAL_BIT");
        }
        if ((flags & MULTI_INSTANCE) != 0) {
            detectedFlagBits.add("VK_MEMORY_HEAP_MULTI_INSTANCE_BIT");
        }
        if ((flags & TILE_MEMORY_QCOM) != 0) {
            detectedFlagBits.add("VK_MEMORY_HEAP_TILE_MEMORY_BIT_QCOM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryHeapFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryAllocateFlags.html"><code>VkMemoryAllocateFlags</code></a>
public final class VkMemoryAllocateFlags {
    public static final int DEVICE_ADDRESS = 0x2;
    public static final int DEVICE_ADDRESS_CAPTURE_REPLAY = 0x4;
    public static final int DEVICE_MASK = 0x1;
    public static final int ZERO_INITIALIZE_EXT = 0x8;

    public static String explain(@Bitmask(VkMemoryAllocateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_ADDRESS) != 0) {
            detectedFlagBits.add("VK_MEMORY_ALLOCATE_DEVICE_ADDRESS_BIT");
        }
        if ((flags & DEVICE_ADDRESS_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_MEMORY_ALLOCATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT");
        }
        if ((flags & DEVICE_MASK) != 0) {
            detectedFlagBits.add("VK_MEMORY_ALLOCATE_DEVICE_MASK_BIT");
        }
        if ((flags & ZERO_INITIALIZE_EXT) != 0) {
            detectedFlagBits.add("VK_MEMORY_ALLOCATE_ZERO_INITIALIZE_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryAllocateFlags() {}
}

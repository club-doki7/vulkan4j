package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreWaitFlags.html"><code>VkSemaphoreWaitFlags</code></a>
public final class VkSemaphoreWaitFlags {
    public static final int ANY = 0x1;

    public static String explain(@Bitmask(VkSemaphoreWaitFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ANY) != 0) {
            detectedFlagBits.add("VK_SEMAPHORE_WAIT_ANY_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSemaphoreWaitFlags() {}
}

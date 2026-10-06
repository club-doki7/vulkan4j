package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkEventCreateFlags.html"><code>VkEventCreateFlags</code></a>
public final class VkEventCreateFlags {
    public static final int DEVICE_ONLY = 0x1;

    public static String explain(@Bitmask(VkEventCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_ONLY) != 0) {
            detectedFlagBits.add("VK_EVENT_CREATE_DEVICE_ONLY_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkEventCreateFlags() {}
}

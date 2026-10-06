package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceQueueCreateFlags.html"><code>VkDeviceQueueCreateFlags</code></a>
public final class VkDeviceQueueCreateFlags {
    public static final int INTERNALLY_SYNCHRONIZED_KHR = 0x4;
    public static final int PROTECTED = 0x1;

    public static String explain(@Bitmask(VkDeviceQueueCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INTERNALLY_SYNCHRONIZED_KHR) != 0) {
            detectedFlagBits.add("VK_DEVICE_QUEUE_CREATE_INTERNALLY_SYNCHRONIZED_BIT_KHR");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_DEVICE_QUEUE_CREATE_PROTECTED_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceQueueCreateFlags() {}
}

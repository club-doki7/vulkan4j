package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentGravityFlagsKHR.html"><code>VkPresentGravityFlagsKHR</code></a>
public final class VkPresentGravityFlagsKHR {
    public static final int CENTERED = 0x4;
    public static final int MAX = 0x2;
    public static final int MIN = 0x1;

    public static String explain(@Bitmask(VkPresentGravityFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CENTERED) != 0) {
            detectedFlagBits.add("VK_PRESENT_GRAVITY_CENTERED_BIT_KHR");
        }
        if ((flags & MAX) != 0) {
            detectedFlagBits.add("VK_PRESENT_GRAVITY_MAX_BIT_KHR");
        }
        if ((flags & MIN) != 0) {
            detectedFlagBits.add("VK_PRESENT_GRAVITY_MIN_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPresentGravityFlagsKHR() {}
}

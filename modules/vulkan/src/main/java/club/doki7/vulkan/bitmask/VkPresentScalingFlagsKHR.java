package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentScalingFlagsKHR.html"><code>VkPresentScalingFlagsKHR</code></a>
public final class VkPresentScalingFlagsKHR {
    public static final int ASPECT_RATIO_STRETCH = 0x2;
    public static final int ONE_TO_ONE = 0x1;
    public static final int STRETCH = 0x4;

    public static String explain(@Bitmask(VkPresentScalingFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ASPECT_RATIO_STRETCH) != 0) {
            detectedFlagBits.add("VK_PRESENT_SCALING_ASPECT_RATIO_STRETCH_BIT_KHR");
        }
        if ((flags & ONE_TO_ONE) != 0) {
            detectedFlagBits.add("VK_PRESENT_SCALING_ONE_TO_ONE_BIT_KHR");
        }
        if ((flags & STRETCH) != 0) {
            detectedFlagBits.add("VK_PRESENT_SCALING_STRETCH_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPresentScalingFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorComponentFlags.html"><code>VkColorComponentFlags</code></a>
public final class VkColorComponentFlags {
    public static final int A = 0x8;
    public static final int B = 0x4;
    public static final int G = 0x2;
    public static final int R = 0x1;

    public static String explain(@Bitmask(VkColorComponentFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & A) != 0) {
            detectedFlagBits.add("VK_COLOR_COMPONENT_A_BIT");
        }
        if ((flags & B) != 0) {
            detectedFlagBits.add("VK_COLOR_COMPONENT_B_BIT");
        }
        if ((flags & G) != 0) {
            detectedFlagBits.add("VK_COLOR_COMPONENT_G_BIT");
        }
        if ((flags & R) != 0) {
            detectedFlagBits.add("VK_COLOR_COMPONENT_R_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkColorComponentFlags() {}
}

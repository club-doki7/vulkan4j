package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitFlags.html"><code>VkSubmitFlags</code></a>
public final class VkSubmitFlags {
    public static final int PROTECTED = 0x1;

    public static String explain(@Bitmask(VkSubmitFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_SUBMIT_PROTECTED_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSubmitFlags() {}
}

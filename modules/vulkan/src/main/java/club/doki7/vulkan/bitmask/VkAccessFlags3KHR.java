package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccessFlags3KHR.html"><code>VkAccessFlags3KHR</code></a>
public final class VkAccessFlags3KHR {
    public static final long NONE = 0x0L;

    public static String explain(@Bitmask(VkAccessFlags3KHR.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_ACCESS_3_NONE_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccessFlags3KHR() {}
}

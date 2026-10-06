package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferCreateFlags.html"><code>VkFramebufferCreateFlags</code></a>
public final class VkFramebufferCreateFlags {
    public static final int IMAGELESS = 0x1;

    public static String explain(@Bitmask(VkFramebufferCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & IMAGELESS) != 0) {
            detectedFlagBits.add("VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFramebufferCreateFlags() {}
}

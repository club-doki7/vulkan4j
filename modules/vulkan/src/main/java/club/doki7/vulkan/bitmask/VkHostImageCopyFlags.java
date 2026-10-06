package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHostImageCopyFlags.html"><code>VkHostImageCopyFlags</code></a>
public final class VkHostImageCopyFlags {
    public static final int MEMCPY = 0x1;

    public static String explain(@Bitmask(VkHostImageCopyFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & MEMCPY) != 0) {
            detectedFlagBits.add("VK_HOST_IMAGE_COPY_MEMCPY_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkHostImageCopyFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCompressionFlagsEXT.html"><code>VkImageCompressionFlagsEXT</code></a>
public final class VkImageCompressionFlagsEXT {
    public static final int DEFAULT = 0x0;
    public static final int DISABLED = 0x4;
    public static final int FIXED_RATE_DEFAULT = 0x1;
    public static final int FIXED_RATE_EXPLICIT = 0x2;

    public static String explain(@Bitmask(VkImageCompressionFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEFAULT) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_DEFAULT_EXT");
        }
        if ((flags & DISABLED) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_DISABLED_EXT");
        }
        if ((flags & FIXED_RATE_DEFAULT) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_DEFAULT_EXT");
        }
        if ((flags & FIXED_RATE_EXPLICIT) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_EXPLICIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageCompressionFlagsEXT() {}
}

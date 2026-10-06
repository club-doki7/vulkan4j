package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessageSeverityFlagsEXT.html"><code>VkDebugUtilsMessageSeverityFlagsEXT</code></a>
public final class VkDebugUtilsMessageSeverityFlagsEXT {
    public static final int ERROR = 0x1000;
    public static final int INFO = 0x10;
    public static final int VERBOSE = 0x1;
    public static final int WARNING = 0x100;

    public static String explain(@Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ERROR) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_SEVERITY_ERROR_BIT_EXT");
        }
        if ((flags & INFO) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_SEVERITY_INFO_BIT_EXT");
        }
        if ((flags & VERBOSE) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_SEVERITY_VERBOSE_BIT_EXT");
        }
        if ((flags & WARNING) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_SEVERITY_WARNING_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDebugUtilsMessageSeverityFlagsEXT() {}
}

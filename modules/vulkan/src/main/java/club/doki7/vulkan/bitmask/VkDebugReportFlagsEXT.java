package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugReportFlagsEXT.html"><code>VkDebugReportFlagsEXT</code></a>
public final class VkDebugReportFlagsEXT {
    public static final int DEBUG = 0x10;
    public static final int ERROR = 0x8;
    public static final int INFORMATION = 0x1;
    public static final int PERFORMANCE_WARNING = 0x4;
    public static final int WARNING = 0x2;

    public static String explain(@Bitmask(VkDebugReportFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEBUG) != 0) {
            detectedFlagBits.add("VK_DEBUG_REPORT_DEBUG_BIT_EXT");
        }
        if ((flags & ERROR) != 0) {
            detectedFlagBits.add("VK_DEBUG_REPORT_ERROR_BIT_EXT");
        }
        if ((flags & INFORMATION) != 0) {
            detectedFlagBits.add("VK_DEBUG_REPORT_INFORMATION_BIT_EXT");
        }
        if ((flags & PERFORMANCE_WARNING) != 0) {
            detectedFlagBits.add("VK_DEBUG_REPORT_PERFORMANCE_WARNING_BIT_EXT");
        }
        if ((flags & WARNING) != 0) {
            detectedFlagBits.add("VK_DEBUG_REPORT_WARNING_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDebugReportFlagsEXT() {}
}

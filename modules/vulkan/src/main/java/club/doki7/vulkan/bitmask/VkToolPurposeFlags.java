package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkToolPurposeFlags.html"><code>VkToolPurposeFlags</code></a>
public final class VkToolPurposeFlags {
    public static final int ADDITIONAL_FEATURES = 0x8;
    public static final int DEBUG_MARKERS_EXT = 0x40;
    public static final int DEBUG_REPORTING_EXT = 0x20;
    public static final int MODIFYING_FEATURES = 0x10;
    public static final int PROFILING = 0x2;
    public static final int TRACING = 0x4;
    public static final int VALIDATION = 0x1;

    public static String explain(@Bitmask(VkToolPurposeFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ADDITIONAL_FEATURES) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_ADDITIONAL_FEATURES_BIT");
        }
        if ((flags & DEBUG_MARKERS_EXT) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_DEBUG_MARKERS_BIT_EXT");
        }
        if ((flags & DEBUG_REPORTING_EXT) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_DEBUG_REPORTING_BIT_EXT");
        }
        if ((flags & MODIFYING_FEATURES) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_MODIFYING_FEATURES_BIT");
        }
        if ((flags & PROFILING) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_PROFILING_BIT");
        }
        if ((flags & TRACING) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_TRACING_BIT");
        }
        if ((flags & VALIDATION) != 0) {
            detectedFlagBits.add("VK_TOOL_PURPOSE_VALIDATION_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkToolPurposeFlags() {}
}

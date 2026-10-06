package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalMemoryFeatureFlags.html"><code>VkExternalMemoryFeatureFlags</code></a>
public final class VkExternalMemoryFeatureFlags {
    public static final int DEDICATED_ONLY = 0x1;
    public static final int EXPORTABLE = 0x2;
    public static final int IMPORTABLE = 0x4;

    public static String explain(@Bitmask(VkExternalMemoryFeatureFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEDICATED_ONLY) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_FEATURE_DEDICATED_ONLY_BIT");
        }
        if ((flags & EXPORTABLE) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_FEATURE_EXPORTABLE_BIT");
        }
        if ((flags & IMPORTABLE) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_FEATURE_IMPORTABLE_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkExternalMemoryFeatureFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFenceImportFlags.html"><code>VkFenceImportFlags</code></a>
public final class VkFenceImportFlags {
    public static final int TEMPORARY = 0x1;

    public static String explain(@Bitmask(VkFenceImportFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & TEMPORARY) != 0) {
            detectedFlagBits.add("VK_FENCE_IMPORT_TEMPORARY_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFenceImportFlags() {}
}

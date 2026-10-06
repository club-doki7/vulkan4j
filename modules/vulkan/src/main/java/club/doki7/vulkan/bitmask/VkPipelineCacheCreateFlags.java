package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCacheCreateFlags.html"><code>VkPipelineCacheCreateFlags</code></a>
public final class VkPipelineCacheCreateFlags {
    public static final int EXTERNALLY_SYNCHRONIZED = 0x1;
    public static final int INTERNALLY_SYNCHRONIZED_MERGE_KHR = 0x8;

    public static String explain(@Bitmask(VkPipelineCacheCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & EXTERNALLY_SYNCHRONIZED) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CACHE_CREATE_EXTERNALLY_SYNCHRONIZED_BIT");
        }
        if ((flags & INTERNALLY_SYNCHRONIZED_MERGE_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CACHE_CREATE_INTERNALLY_SYNCHRONIZED_MERGE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineCacheCreateFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPeerMemoryFeatureFlags.html"><code>VkPeerMemoryFeatureFlags</code></a>
public final class VkPeerMemoryFeatureFlags {
    public static final int COPY_DST = 0x2;
    public static final int COPY_SRC = 0x1;
    public static final int GENERIC_DST = 0x8;
    public static final int GENERIC_SRC = 0x4;

    public static String explain(@Bitmask(VkPeerMemoryFeatureFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & COPY_DST) != 0) {
            detectedFlagBits.add("VK_PEER_MEMORY_FEATURE_COPY_DST_BIT");
        }
        if ((flags & COPY_SRC) != 0) {
            detectedFlagBits.add("VK_PEER_MEMORY_FEATURE_COPY_SRC_BIT");
        }
        if ((flags & GENERIC_DST) != 0) {
            detectedFlagBits.add("VK_PEER_MEMORY_FEATURE_GENERIC_DST_BIT");
        }
        if ((flags & GENERIC_SRC) != 0) {
            detectedFlagBits.add("VK_PEER_MEMORY_FEATURE_GENERIC_SRC_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPeerMemoryFeatureFlags() {}
}

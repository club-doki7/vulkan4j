package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectStateFlagsNV.html"><code>VkIndirectStateFlagsNV</code></a>
public final class VkIndirectStateFlagsNV {
    public static final int FLAG_FRONTFACE = 0x1;

    public static String explain(@Bitmask(VkIndirectStateFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FLAG_FRONTFACE) != 0) {
            detectedFlagBits.add("VK_INDIRECT_STATE_FLAG_FRONTFACE_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectStateFlagsNV() {}
}

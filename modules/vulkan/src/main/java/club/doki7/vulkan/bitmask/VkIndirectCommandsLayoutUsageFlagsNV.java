package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutUsageFlagsNV.html"><code>VkIndirectCommandsLayoutUsageFlagsNV</code></a>
public final class VkIndirectCommandsLayoutUsageFlagsNV {
    public static final int EXPLICIT_PREPROCESS = 0x1;
    public static final int INDEXED_SEQUENCES = 0x2;
    public static final int UNORDERED_SEQUENCES = 0x4;

    public static String explain(@Bitmask(VkIndirectCommandsLayoutUsageFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & EXPLICIT_PREPROCESS) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_LAYOUT_USAGE_EXPLICIT_PREPROCESS_BIT_NV");
        }
        if ((flags & INDEXED_SEQUENCES) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_LAYOUT_USAGE_INDEXED_SEQUENCES_BIT_NV");
        }
        if ((flags & UNORDERED_SEQUENCES) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_LAYOUT_USAGE_UNORDERED_SEQUENCES_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectCommandsLayoutUsageFlagsNV() {}
}

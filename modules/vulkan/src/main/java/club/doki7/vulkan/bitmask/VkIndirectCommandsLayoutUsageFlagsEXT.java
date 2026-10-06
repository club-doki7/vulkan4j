package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutUsageFlagsEXT.html"><code>VkIndirectCommandsLayoutUsageFlagsEXT</code></a>
public final class VkIndirectCommandsLayoutUsageFlagsEXT {
    public static final int EXPLICIT_PREPROCESS = 0x1;
    public static final int UNORDERED_SEQUENCES = 0x2;

    public static String explain(@Bitmask(VkIndirectCommandsLayoutUsageFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & EXPLICIT_PREPROCESS) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_LAYOUT_USAGE_EXPLICIT_PREPROCESS_BIT_EXT");
        }
        if ((flags & UNORDERED_SEQUENCES) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_LAYOUT_USAGE_UNORDERED_SEQUENCES_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectCommandsLayoutUsageFlagsEXT() {}
}

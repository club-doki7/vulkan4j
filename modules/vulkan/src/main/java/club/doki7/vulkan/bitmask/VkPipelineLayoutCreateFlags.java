package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineLayoutCreateFlags.html"><code>VkPipelineLayoutCreateFlags</code></a>
public final class VkPipelineLayoutCreateFlags {
    public static final int INDEPENDENT_SETS_EXT = 0x2;
    public static final int NO_TASK_SHADER_KHR = 0x4;

    public static String explain(@Bitmask(VkPipelineLayoutCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INDEPENDENT_SETS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_LAYOUT_CREATE_INDEPENDENT_SETS_BIT_EXT");
        }
        if ((flags & NO_TASK_SHADER_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_LAYOUT_CREATE_NO_TASK_SHADER_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineLayoutCreateFlags() {}
}

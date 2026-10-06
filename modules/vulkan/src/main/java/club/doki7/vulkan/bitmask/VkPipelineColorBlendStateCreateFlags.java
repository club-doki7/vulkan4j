package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendStateCreateFlags.html"><code>VkPipelineColorBlendStateCreateFlags</code></a>
public final class VkPipelineColorBlendStateCreateFlags {
    public static final int RASTERIZATION_ORDER_ATTACHMENT_ACCESS_EXT = 0x1;

    public static String explain(@Bitmask(VkPipelineColorBlendStateCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_COLOR_BLEND_STATE_CREATE_RASTERIZATION_ORDER_ATTACHMENT_ACCESS_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineColorBlendStateCreateFlags() {}
}

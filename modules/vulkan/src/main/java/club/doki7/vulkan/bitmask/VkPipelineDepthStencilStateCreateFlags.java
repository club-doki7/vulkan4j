package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDepthStencilStateCreateFlags.html"><code>VkPipelineDepthStencilStateCreateFlags</code></a>
public final class VkPipelineDepthStencilStateCreateFlags {
    public static final int RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_EXT = 0x1;
    public static final int RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_EXT = 0x2;

    public static String explain(@Bitmask(VkPipelineDepthStencilStateCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_DEPTH_STENCIL_STATE_CREATE_RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_BIT_EXT");
        }
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_DEPTH_STENCIL_STATE_CREATE_RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineDepthStencilStateCreateFlags() {}
}

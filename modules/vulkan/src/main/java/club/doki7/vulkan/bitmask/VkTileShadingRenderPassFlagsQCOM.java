package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTileShadingRenderPassFlagsQCOM.html"><code>VkTileShadingRenderPassFlagsQCOM</code></a>
public final class VkTileShadingRenderPassFlagsQCOM {
    public static final int ENABLE = 0x1;
    public static final int PER_TILE_EXECUTION = 0x2;

    public static String explain(@Bitmask(VkTileShadingRenderPassFlagsQCOM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ENABLE) != 0) {
            detectedFlagBits.add("VK_TILE_SHADING_RENDER_PASS_ENABLE_BIT_QCOM");
        }
        if ((flags & PER_TILE_EXECUTION) != 0) {
            detectedFlagBits.add("VK_TILE_SHADING_RENDER_PASS_PER_TILE_EXECUTION_BIT_QCOM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTileShadingRenderPassFlagsQCOM() {}
}

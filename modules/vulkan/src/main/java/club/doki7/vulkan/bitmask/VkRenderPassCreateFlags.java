package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassCreateFlags.html"><code>VkRenderPassCreateFlags</code></a>
public final class VkRenderPassCreateFlags {
    public static final int PER_LAYER_FRAGMENT_DENSITY_VALVE = 0x4;
    public static final int TRANSFORM_QCOM = 0x2;

    public static String explain(@Bitmask(VkRenderPassCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PER_LAYER_FRAGMENT_DENSITY_VALVE) != 0) {
            detectedFlagBits.add("VK_RENDER_PASS_CREATE_PER_LAYER_FRAGMENT_DENSITY_BIT_VALVE");
        }
        if ((flags & TRANSFORM_QCOM) != 0) {
            detectedFlagBits.add("VK_RENDER_PASS_CREATE_TRANSFORM_BIT_QCOM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRenderPassCreateFlags() {}
}

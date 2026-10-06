package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorUsageFlagsARM.html"><code>VkTensorUsageFlagsARM</code></a>
public final class VkTensorUsageFlagsARM {
    public static final long DATA_GRAPH = 0x20L;
    public static final long IMAGE_ALIASING = 0x10L;
    public static final long SHADER = 0x2L;
    public static final long TRANSFER_DST = 0x8L;
    public static final long TRANSFER_SRC = 0x4L;

    public static String explain(@Bitmask(VkTensorUsageFlagsARM.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DATA_GRAPH) != 0) {
            detectedFlagBits.add("VK_TENSOR_USAGE_DATA_GRAPH_BIT_ARM");
        }
        if ((flags & IMAGE_ALIASING) != 0) {
            detectedFlagBits.add("VK_TENSOR_USAGE_IMAGE_ALIASING_BIT_ARM");
        }
        if ((flags & SHADER) != 0) {
            detectedFlagBits.add("VK_TENSOR_USAGE_SHADER_BIT_ARM");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_TENSOR_USAGE_TRANSFER_DST_BIT_ARM");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_TENSOR_USAGE_TRANSFER_SRC_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTensorUsageFlagsARM() {}
}

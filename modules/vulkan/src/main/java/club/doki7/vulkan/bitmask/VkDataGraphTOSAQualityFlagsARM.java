package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphTOSAQualityFlagsARM.html"><code>VkDataGraphTOSAQualityFlagsARM</code></a>
public final class VkDataGraphTOSAQualityFlagsARM {
    public static final int VK_DATA_GRAPH_TOSA_QUALITY_ACCELERATED = 0x1;
    public static final int VK_DATA_GRAPH_TOSA_QUALITY_CONFORMANT = 0x2;
    public static final int VK_DATA_GRAPH_TOSA_QUALITY_DEPRECATED = 0x8;
    public static final int VK_DATA_GRAPH_TOSA_QUALITY_EXPERIMENTAL = 0x4;

    public static String explain(@Bitmask(VkDataGraphTOSAQualityFlagsARM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_DATA_GRAPH_TOSA_QUALITY_ACCELERATED) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_TOSA_QUALITY_ACCELERATED_ARM");
        }
        if ((flags & VK_DATA_GRAPH_TOSA_QUALITY_CONFORMANT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_TOSA_QUALITY_CONFORMANT_ARM");
        }
        if ((flags & VK_DATA_GRAPH_TOSA_QUALITY_DEPRECATED) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_TOSA_QUALITY_DEPRECATED_ARM");
        }
        if ((flags & VK_DATA_GRAPH_TOSA_QUALITY_EXPERIMENTAL) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_TOSA_QUALITY_EXPERIMENTAL_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphTOSAQualityFlagsARM() {}
}

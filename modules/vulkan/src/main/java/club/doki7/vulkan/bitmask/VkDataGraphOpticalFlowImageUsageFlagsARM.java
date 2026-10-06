package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphOpticalFlowImageUsageFlagsARM.html"><code>VkDataGraphOpticalFlowImageUsageFlagsARM</code></a>
public final class VkDataGraphOpticalFlowImageUsageFlagsARM {
    public static final int COST = 0x8;
    public static final int HINT = 0x4;
    public static final int INPUT = 0x1;
    public static final int OUTPUT = 0x2;
    public static final int UNKNOWN = 0x0;

    public static String explain(@Bitmask(VkDataGraphOpticalFlowImageUsageFlagsARM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & COST) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_IMAGE_USAGE_COST_BIT_ARM");
        }
        if ((flags & HINT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_IMAGE_USAGE_HINT_BIT_ARM");
        }
        if ((flags & INPUT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_IMAGE_USAGE_INPUT_BIT_ARM");
        }
        if ((flags & OUTPUT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_IMAGE_USAGE_OUTPUT_BIT_ARM");
        }
        if ((flags & UNKNOWN) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_IMAGE_USAGE_UNKNOWN_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphOpticalFlowImageUsageFlagsARM() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowUsageFlagsNV.html"><code>VkOpticalFlowUsageFlagsNV</code></a>
public final class VkOpticalFlowUsageFlagsNV {
    public static final int COST = 0x8;
    public static final int GLOBAL_FLOW = 0x10;
    public static final int HINT = 0x4;
    public static final int INPUT = 0x1;
    public static final int OUTPUT = 0x2;
    public static final int UNKNOWN = 0x0;

    public static String explain(@Bitmask(VkOpticalFlowUsageFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & COST) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_COST_BIT_NV");
        }
        if ((flags & GLOBAL_FLOW) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_GLOBAL_FLOW_BIT_NV");
        }
        if ((flags & HINT) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_HINT_BIT_NV");
        }
        if ((flags & INPUT) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_INPUT_BIT_NV");
        }
        if ((flags & OUTPUT) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_OUTPUT_BIT_NV");
        }
        if ((flags & UNKNOWN) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_USAGE_UNKNOWN_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpticalFlowUsageFlagsNV() {}
}

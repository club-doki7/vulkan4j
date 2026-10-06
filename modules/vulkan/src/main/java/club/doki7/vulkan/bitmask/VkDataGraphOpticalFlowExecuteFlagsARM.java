package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphOpticalFlowExecuteFlagsARM.html"><code>VkDataGraphOpticalFlowExecuteFlagsARM</code></a>
public final class VkDataGraphOpticalFlowExecuteFlagsARM {
    public static final int DISABLE_TEMPORAL_HINTS = 0x1;
    public static final int INPUT_IS_PREVIOUS_REFERENCE = 0x8;
    public static final int INPUT_UNCHANGED = 0x2;
    public static final int REFERENCE_IS_PREVIOUS_INPUT = 0x10;
    public static final int REFERENCE_UNCHANGED = 0x4;

    public static String explain(@Bitmask(VkDataGraphOpticalFlowExecuteFlagsARM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DISABLE_TEMPORAL_HINTS) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_EXECUTE_DISABLE_TEMPORAL_HINTS_BIT_ARM");
        }
        if ((flags & INPUT_IS_PREVIOUS_REFERENCE) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_EXECUTE_INPUT_IS_PREVIOUS_REFERENCE_BIT_ARM");
        }
        if ((flags & INPUT_UNCHANGED) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_EXECUTE_INPUT_UNCHANGED_BIT_ARM");
        }
        if ((flags & REFERENCE_IS_PREVIOUS_INPUT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_EXECUTE_REFERENCE_IS_PREVIOUS_INPUT_BIT_ARM");
        }
        if ((flags & REFERENCE_UNCHANGED) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_EXECUTE_REFERENCE_UNCHANGED_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphOpticalFlowExecuteFlagsARM() {}
}

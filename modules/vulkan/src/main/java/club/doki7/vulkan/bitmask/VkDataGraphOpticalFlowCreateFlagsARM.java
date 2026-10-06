package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphOpticalFlowCreateFlagsARM.html"><code>VkDataGraphOpticalFlowCreateFlagsARM</code></a>
public final class VkDataGraphOpticalFlowCreateFlagsARM {
    public static final int ENABLE_COST = 0x2;
    public static final int ENABLE_HINT = 0x1;
    public static final int RESERVED_30 = 0x40000000;

    public static String explain(@Bitmask(VkDataGraphOpticalFlowCreateFlagsARM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ENABLE_COST) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_CREATE_ENABLE_COST_BIT_ARM");
        }
        if ((flags & ENABLE_HINT) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_CREATE_ENABLE_HINT_BIT_ARM");
        }
        if ((flags & RESERVED_30) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_CREATE_RESERVED_30_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphOpticalFlowCreateFlagsARM() {}
}

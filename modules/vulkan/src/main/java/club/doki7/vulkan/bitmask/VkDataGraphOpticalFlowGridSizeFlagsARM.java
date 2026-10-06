package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphOpticalFlowGridSizeFlagsARM.html"><code>VkDataGraphOpticalFlowGridSizeFlagsARM</code></a>
public final class VkDataGraphOpticalFlowGridSizeFlagsARM {
    public static final int _1X1 = 0x1;
    public static final int _2X2 = 0x2;
    public static final int _4X4 = 0x4;
    public static final int _8X8 = 0x8;
    public static final int UNKNOWN = 0x0;

    public static String explain(@Bitmask(VkDataGraphOpticalFlowGridSizeFlagsARM.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _1X1) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_GRID_SIZE_1X1_BIT_ARM");
        }
        if ((flags & _2X2) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_GRID_SIZE_2X2_BIT_ARM");
        }
        if ((flags & _4X4) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_GRID_SIZE_4X4_BIT_ARM");
        }
        if ((flags & _8X8) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_GRID_SIZE_8X8_BIT_ARM");
        }
        if ((flags & UNKNOWN) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_OPTICAL_FLOW_GRID_SIZE_UNKNOWN_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphOpticalFlowGridSizeFlagsARM() {}
}

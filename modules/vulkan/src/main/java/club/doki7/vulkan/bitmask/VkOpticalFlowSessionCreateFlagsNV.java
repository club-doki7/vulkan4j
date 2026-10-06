package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreateFlagsNV.html"><code>VkOpticalFlowSessionCreateFlagsNV</code></a>
public final class VkOpticalFlowSessionCreateFlagsNV {
    public static final int ALLOW_REGIONS = 0x8;
    public static final int BOTH_DIRECTIONS = 0x10;
    public static final int ENABLE_COST = 0x2;
    public static final int ENABLE_GLOBAL_FLOW = 0x4;
    public static final int ENABLE_HINT = 0x1;

    public static String explain(@Bitmask(VkOpticalFlowSessionCreateFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_REGIONS) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_SESSION_CREATE_ALLOW_REGIONS_BIT_NV");
        }
        if ((flags & BOTH_DIRECTIONS) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_SESSION_CREATE_BOTH_DIRECTIONS_BIT_NV");
        }
        if ((flags & ENABLE_COST) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_SESSION_CREATE_ENABLE_COST_BIT_NV");
        }
        if ((flags & ENABLE_GLOBAL_FLOW) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_SESSION_CREATE_ENABLE_GLOBAL_FLOW_BIT_NV");
        }
        if ((flags & ENABLE_HINT) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_SESSION_CREATE_ENABLE_HINT_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpticalFlowSessionCreateFlagsNV() {}
}

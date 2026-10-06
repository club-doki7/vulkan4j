package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowExecuteFlagsNV.html"><code>VkOpticalFlowExecuteFlagsNV</code></a>
public final class VkOpticalFlowExecuteFlagsNV {
    public static final int DISABLE_TEMPORAL_HINTS = 0x1;

    public static String explain(@Bitmask(VkOpticalFlowExecuteFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DISABLE_TEMPORAL_HINTS) != 0) {
            detectedFlagBits.add("VK_OPTICAL_FLOW_EXECUTE_DISABLE_TEMPORAL_HINTS_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpticalFlowExecuteFlagsNV() {}
}

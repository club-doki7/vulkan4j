package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionCreateFlagsARM.html"><code>VkDataGraphPipelineSessionCreateFlagsARM</code></a>
public final class VkDataGraphPipelineSessionCreateFlagsARM {
    public static final long OPTICAL_FLOW_CACHE = 0x2L;
    public static final long PROTECTED = 0x1L;

    public static String explain(@Bitmask(VkDataGraphPipelineSessionCreateFlagsARM.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & OPTICAL_FLOW_CACHE) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_PIPELINE_SESSION_CREATE_OPTICAL_FLOW_CACHE_BIT_ARM");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_DATA_GRAPH_PIPELINE_SESSION_CREATE_PROTECTED_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelineSessionCreateFlagsARM() {}
}

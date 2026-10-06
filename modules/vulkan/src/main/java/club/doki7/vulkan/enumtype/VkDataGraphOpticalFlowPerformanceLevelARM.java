package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphOpticalFlowPerformanceLevelARM.html"><code>VkDataGraphOpticalFlowPerformanceLevelARM</code></a>
public final class VkDataGraphOpticalFlowPerformanceLevelARM {
    public static final int UNKNOWN = 0x0;
    public static final int SLOW = 0x1;
    public static final int MEDIUM = 0x2;
    public static final int FAST = 0x3;

    public static String explain(@EnumType(VkDataGraphOpticalFlowPerformanceLevelARM.class) int value) {
        return switch (value) {
            case VkDataGraphOpticalFlowPerformanceLevelARM.FAST -> "VK_DATA_GRAPH_OPTICAL_FLOW_PERFORMANCE_LEVEL_FAST_ARM";
            case VkDataGraphOpticalFlowPerformanceLevelARM.MEDIUM -> "VK_DATA_GRAPH_OPTICAL_FLOW_PERFORMANCE_LEVEL_MEDIUM_ARM";
            case VkDataGraphOpticalFlowPerformanceLevelARM.SLOW -> "VK_DATA_GRAPH_OPTICAL_FLOW_PERFORMANCE_LEVEL_SLOW_ARM";
            case VkDataGraphOpticalFlowPerformanceLevelARM.UNKNOWN -> "VK_DATA_GRAPH_OPTICAL_FLOW_PERFORMANCE_LEVEL_UNKNOWN_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphOpticalFlowPerformanceLevelARM() {}
}

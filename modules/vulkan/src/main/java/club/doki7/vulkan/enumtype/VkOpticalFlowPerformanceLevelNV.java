package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowPerformanceLevelNV.html"><code>VkOpticalFlowPerformanceLevelNV</code></a>
public final class VkOpticalFlowPerformanceLevelNV {
    public static final int UNKNOWN = 0x0;
    public static final int SLOW = 0x1;
    public static final int MEDIUM = 0x2;
    public static final int FAST = 0x3;

    public static String explain(@EnumType(VkOpticalFlowPerformanceLevelNV.class) int value) {
        return switch (value) {
            case VkOpticalFlowPerformanceLevelNV.FAST -> "VK_OPTICAL_FLOW_PERFORMANCE_LEVEL_FAST_NV";
            case VkOpticalFlowPerformanceLevelNV.MEDIUM -> "VK_OPTICAL_FLOW_PERFORMANCE_LEVEL_MEDIUM_NV";
            case VkOpticalFlowPerformanceLevelNV.SLOW -> "VK_OPTICAL_FLOW_PERFORMANCE_LEVEL_SLOW_NV";
            case VkOpticalFlowPerformanceLevelNV.UNKNOWN -> "VK_OPTICAL_FLOW_PERFORMANCE_LEVEL_UNKNOWN_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpticalFlowPerformanceLevelNV() {}
}

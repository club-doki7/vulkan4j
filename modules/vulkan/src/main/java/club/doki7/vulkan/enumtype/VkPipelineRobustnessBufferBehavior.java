package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRobustnessBufferBehavior.html"><code>VkPipelineRobustnessBufferBehavior</code></a>
public final class VkPipelineRobustnessBufferBehavior {
    public static final int DEVICE_DEFAULT = 0x0;
    public static final int DISABLED = 0x1;
    public static final int ROBUST_BUFFER_ACCESS = 0x2;
    public static final int ROBUST_BUFFER_ACCESS_2 = 0x3;

    public static String explain(@EnumType(VkPipelineRobustnessBufferBehavior.class) int value) {
        return switch (value) {
            case VkPipelineRobustnessBufferBehavior.DEVICE_DEFAULT -> "VK_PIPELINE_ROBUSTNESS_BUFFER_BEHAVIOR_DEVICE_DEFAULT";
            case VkPipelineRobustnessBufferBehavior.DISABLED -> "VK_PIPELINE_ROBUSTNESS_BUFFER_BEHAVIOR_DISABLED";
            case VkPipelineRobustnessBufferBehavior.ROBUST_BUFFER_ACCESS -> "VK_PIPELINE_ROBUSTNESS_BUFFER_BEHAVIOR_ROBUST_BUFFER_ACCESS";
            case VkPipelineRobustnessBufferBehavior.ROBUST_BUFFER_ACCESS_2 -> "VK_PIPELINE_ROBUSTNESS_BUFFER_BEHAVIOR_ROBUST_BUFFER_ACCESS_2";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineRobustnessBufferBehavior() {}
}

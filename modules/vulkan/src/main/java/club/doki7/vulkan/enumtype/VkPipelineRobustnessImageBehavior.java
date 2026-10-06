package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRobustnessImageBehavior.html"><code>VkPipelineRobustnessImageBehavior</code></a>
public final class VkPipelineRobustnessImageBehavior {
    public static final int DEVICE_DEFAULT = 0x0;
    public static final int DISABLED = 0x1;
    public static final int ROBUST_IMAGE_ACCESS = 0x2;
    public static final int ROBUST_IMAGE_ACCESS_2 = 0x3;

    public static String explain(@EnumType(VkPipelineRobustnessImageBehavior.class) int value) {
        return switch (value) {
            case VkPipelineRobustnessImageBehavior.DEVICE_DEFAULT -> "VK_PIPELINE_ROBUSTNESS_IMAGE_BEHAVIOR_DEVICE_DEFAULT";
            case VkPipelineRobustnessImageBehavior.DISABLED -> "VK_PIPELINE_ROBUSTNESS_IMAGE_BEHAVIOR_DISABLED";
            case VkPipelineRobustnessImageBehavior.ROBUST_IMAGE_ACCESS -> "VK_PIPELINE_ROBUSTNESS_IMAGE_BEHAVIOR_ROBUST_IMAGE_ACCESS";
            case VkPipelineRobustnessImageBehavior.ROBUST_IMAGE_ACCESS_2 -> "VK_PIPELINE_ROBUSTNESS_IMAGE_BEHAVIOR_ROBUST_IMAGE_ACCESS_2";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineRobustnessImageBehavior() {}
}

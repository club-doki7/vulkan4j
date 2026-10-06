package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceConfigurationTypeINTEL.html"><code>VkPerformanceConfigurationTypeINTEL</code></a>
public final class VkPerformanceConfigurationTypeINTEL {
    public static final int COMMAND_QUEUE_METRICS_DISCOVERY_ACTIVATED = 0x0;

    public static String explain(@EnumType(VkPerformanceConfigurationTypeINTEL.class) int value) {
        return switch (value) {
            case VkPerformanceConfigurationTypeINTEL.COMMAND_QUEUE_METRICS_DISCOVERY_ACTIVATED -> "VK_PERFORMANCE_CONFIGURATION_TYPE_COMMAND_QUEUE_METRICS_DISCOVERY_ACTIVATED_INTEL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceConfigurationTypeINTEL() {}
}

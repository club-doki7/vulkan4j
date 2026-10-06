package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterScopeKHR.html"><code>VkPerformanceCounterScopeKHR</code></a>
public final class VkPerformanceCounterScopeKHR {
    public static final int COMMAND_BUFFER = 0x0;
    public static final int RENDER_PASS = 0x1;
    public static final int COMMAND = 0x2;

    public static String explain(@EnumType(VkPerformanceCounterScopeKHR.class) int value) {
        return switch (value) {
            case VkPerformanceCounterScopeKHR.COMMAND_BUFFER -> "VK_PERFORMANCE_COUNTER_SCOPE_COMMAND_BUFFER_KHR";
            case VkPerformanceCounterScopeKHR.COMMAND -> "VK_PERFORMANCE_COUNTER_SCOPE_COMMAND_KHR";
            case VkPerformanceCounterScopeKHR.RENDER_PASS -> "VK_PERFORMANCE_COUNTER_SCOPE_RENDER_PASS_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceCounterScopeKHR() {}
}

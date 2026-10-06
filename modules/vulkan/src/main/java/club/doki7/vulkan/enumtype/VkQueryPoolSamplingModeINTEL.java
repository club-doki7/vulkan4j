package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryPoolSamplingModeINTEL.html"><code>VkQueryPoolSamplingModeINTEL</code></a>
public final class VkQueryPoolSamplingModeINTEL {
    public static final int MANUAL = 0x0;

    public static String explain(@EnumType(VkQueryPoolSamplingModeINTEL.class) int value) {
        return switch (value) {
            case VkQueryPoolSamplingModeINTEL.MANUAL -> "VK_QUERY_POOL_SAMPLING_MODE_MANUAL_INTEL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryPoolSamplingModeINTEL() {}
}

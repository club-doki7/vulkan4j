package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkThrottleHintTypeSEC.html"><code>VkThrottleHintTypeSEC</code></a>
public final class VkThrottleHintTypeSEC {
    public static final int DEFAULT = 0x0;
    public static final int LOW = 0x1;
    public static final int HIGH = 0x2;

    public static String explain(@EnumType(VkThrottleHintTypeSEC.class) int value) {
        return switch (value) {
            case VkThrottleHintTypeSEC.DEFAULT -> "VK_THROTTLE_HINT_TYPE_DEFAULT_SEC";
            case VkThrottleHintTypeSEC.HIGH -> "VK_THROTTLE_HINT_TYPE_HIGH_SEC";
            case VkThrottleHintTypeSEC.LOW -> "VK_THROTTLE_HINT_TYPE_LOW_SEC";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkThrottleHintTypeSEC() {}
}

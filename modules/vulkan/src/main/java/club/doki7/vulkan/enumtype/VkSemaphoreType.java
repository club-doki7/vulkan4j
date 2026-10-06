package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreType.html"><code>VkSemaphoreType</code></a>
public final class VkSemaphoreType {
    public static final int BINARY = 0x0;
    public static final int TIMELINE = 0x1;

    public static String explain(@EnumType(VkSemaphoreType.class) int value) {
        return switch (value) {
            case VkSemaphoreType.BINARY -> "VK_SEMAPHORE_TYPE_BINARY";
            case VkSemaphoreType.TIMELINE -> "VK_SEMAPHORE_TYPE_TIMELINE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSemaphoreType() {}
}

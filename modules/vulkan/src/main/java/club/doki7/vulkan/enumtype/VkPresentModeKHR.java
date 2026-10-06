package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentModeKHR.html"><code>VkPresentModeKHR</code></a>
public final class VkPresentModeKHR {
    public static final int IMMEDIATE = 0x0;
    public static final int MAILBOX = 0x1;
    public static final int FIFO = 0x2;
    public static final int FIFO_RELAXED = 0x3;
    public static final int SHARED_DEMAND_REFRESH = 0x3b9c7b98;
    public static final int SHARED_CONTINUOUS_REFRESH = 0x3b9c7b99;
    public static final int FIFO_LATEST_READY = 0x3ba04c28;

    public static String explain(@EnumType(VkPresentModeKHR.class) int value) {
        return switch (value) {
            case VkPresentModeKHR.FIFO -> "VK_PRESENT_MODE_FIFO_KHR";
            case VkPresentModeKHR.FIFO_LATEST_READY -> "VK_PRESENT_MODE_FIFO_LATEST_READY_KHR";
            case VkPresentModeKHR.FIFO_RELAXED -> "VK_PRESENT_MODE_FIFO_RELAXED_KHR";
            case VkPresentModeKHR.IMMEDIATE -> "VK_PRESENT_MODE_IMMEDIATE_KHR";
            case VkPresentModeKHR.MAILBOX -> "VK_PRESENT_MODE_MAILBOX_KHR";
            case VkPresentModeKHR.SHARED_CONTINUOUS_REFRESH -> "VK_PRESENT_MODE_SHARED_CONTINUOUS_REFRESH_KHR";
            case VkPresentModeKHR.SHARED_DEMAND_REFRESH -> "VK_PRESENT_MODE_SHARED_DEMAND_REFRESH_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPresentModeKHR() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTimeDomainKHR.html"><code>VkTimeDomainKHR</code></a>
public final class VkTimeDomainKHR {
    public static final int DEVICE = 0x0;
    public static final int CLOCK_MONOTONIC = 0x1;
    public static final int CLOCK_MONOTONIC_RAW = 0x2;
    public static final int QUERY_PERFORMANCE_COUNTER = 0x3;
    public static final int PRESENT_STAGE_LOCAL_EXT = 0x3b9df680;
    public static final int SWAPCHAIN_LOCAL_EXT = 0x3b9df681;

    public static String explain(@EnumType(VkTimeDomainKHR.class) int value) {
        return switch (value) {
            case VkTimeDomainKHR.CLOCK_MONOTONIC -> "VK_TIME_DOMAIN_CLOCK_MONOTONIC_KHR";
            case VkTimeDomainKHR.CLOCK_MONOTONIC_RAW -> "VK_TIME_DOMAIN_CLOCK_MONOTONIC_RAW_KHR";
            case VkTimeDomainKHR.DEVICE -> "VK_TIME_DOMAIN_DEVICE_KHR";
            case VkTimeDomainKHR.PRESENT_STAGE_LOCAL_EXT -> "VK_TIME_DOMAIN_PRESENT_STAGE_LOCAL_EXT";
            case VkTimeDomainKHR.QUERY_PERFORMANCE_COUNTER -> "VK_TIME_DOMAIN_QUERY_PERFORMANCE_COUNTER_KHR";
            case VkTimeDomainKHR.SWAPCHAIN_LOCAL_EXT -> "VK_TIME_DOMAIN_SWAPCHAIN_LOCAL_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTimeDomainKHR() {}
}

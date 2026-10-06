package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterStorageKHR.html"><code>VkPerformanceCounterStorageKHR</code></a>
public final class VkPerformanceCounterStorageKHR {
    public static final int INT32 = 0x0;
    public static final int INT64 = 0x1;
    public static final int UINT32 = 0x2;
    public static final int UINT64 = 0x3;
    public static final int FLOAT32 = 0x4;
    public static final int FLOAT64 = 0x5;

    public static String explain(@EnumType(VkPerformanceCounterStorageKHR.class) int value) {
        return switch (value) {
            case VkPerformanceCounterStorageKHR.FLOAT32 -> "VK_PERFORMANCE_COUNTER_STORAGE_FLOAT32_KHR";
            case VkPerformanceCounterStorageKHR.FLOAT64 -> "VK_PERFORMANCE_COUNTER_STORAGE_FLOAT64_KHR";
            case VkPerformanceCounterStorageKHR.INT32 -> "VK_PERFORMANCE_COUNTER_STORAGE_INT32_KHR";
            case VkPerformanceCounterStorageKHR.INT64 -> "VK_PERFORMANCE_COUNTER_STORAGE_INT64_KHR";
            case VkPerformanceCounterStorageKHR.UINT32 -> "VK_PERFORMANCE_COUNTER_STORAGE_UINT32_KHR";
            case VkPerformanceCounterStorageKHR.UINT64 -> "VK_PERFORMANCE_COUNTER_STORAGE_UINT64_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceCounterStorageKHR() {}
}

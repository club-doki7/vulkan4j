package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaDeviceClockModeAMD.html"><code>VkGpaDeviceClockModeAMD</code></a>
public final class VkGpaDeviceClockModeAMD {
    public static final int DEFAULT = 0x0;
    public static final int QUERY = 0x1;
    public static final int PROFILING = 0x2;
    public static final int MIN_MEMORY = 0x3;
    public static final int MIN_ENGINE = 0x4;
    public static final int PEAK = 0x5;

    public static String explain(@EnumType(VkGpaDeviceClockModeAMD.class) int value) {
        return switch (value) {
            case VkGpaDeviceClockModeAMD.DEFAULT -> "VK_GPA_DEVICE_CLOCK_MODE_DEFAULT_AMD";
            case VkGpaDeviceClockModeAMD.MIN_ENGINE -> "VK_GPA_DEVICE_CLOCK_MODE_MIN_ENGINE_AMD";
            case VkGpaDeviceClockModeAMD.MIN_MEMORY -> "VK_GPA_DEVICE_CLOCK_MODE_MIN_MEMORY_AMD";
            case VkGpaDeviceClockModeAMD.PEAK -> "VK_GPA_DEVICE_CLOCK_MODE_PEAK_AMD";
            case VkGpaDeviceClockModeAMD.PROFILING -> "VK_GPA_DEVICE_CLOCK_MODE_PROFILING_AMD";
            case VkGpaDeviceClockModeAMD.QUERY -> "VK_GPA_DEVICE_CLOCK_MODE_QUERY_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGpaDeviceClockModeAMD() {}
}

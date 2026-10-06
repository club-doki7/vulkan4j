package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceCounterUnitKHR.html"><code>VkPerformanceCounterUnitKHR</code></a>
public final class VkPerformanceCounterUnitKHR {
    public static final int GENERIC = 0x0;
    public static final int PERCENTAGE = 0x1;
    public static final int NANOSECONDS = 0x2;
    public static final int BYTES = 0x3;
    public static final int BYTES_PER_SECOND = 0x4;
    public static final int KELVIN = 0x5;
    public static final int WATTS = 0x6;
    public static final int VOLTS = 0x7;
    public static final int AMPS = 0x8;
    public static final int HERTZ = 0x9;
    public static final int CYCLES = 0xa;

    public static String explain(@EnumType(VkPerformanceCounterUnitKHR.class) int value) {
        return switch (value) {
            case VkPerformanceCounterUnitKHR.AMPS -> "VK_PERFORMANCE_COUNTER_UNIT_AMPS_KHR";
            case VkPerformanceCounterUnitKHR.BYTES -> "VK_PERFORMANCE_COUNTER_UNIT_BYTES_KHR";
            case VkPerformanceCounterUnitKHR.BYTES_PER_SECOND -> "VK_PERFORMANCE_COUNTER_UNIT_BYTES_PER_SECOND_KHR";
            case VkPerformanceCounterUnitKHR.CYCLES -> "VK_PERFORMANCE_COUNTER_UNIT_CYCLES_KHR";
            case VkPerformanceCounterUnitKHR.GENERIC -> "VK_PERFORMANCE_COUNTER_UNIT_GENERIC_KHR";
            case VkPerformanceCounterUnitKHR.HERTZ -> "VK_PERFORMANCE_COUNTER_UNIT_HERTZ_KHR";
            case VkPerformanceCounterUnitKHR.KELVIN -> "VK_PERFORMANCE_COUNTER_UNIT_KELVIN_KHR";
            case VkPerformanceCounterUnitKHR.NANOSECONDS -> "VK_PERFORMANCE_COUNTER_UNIT_NANOSECONDS_KHR";
            case VkPerformanceCounterUnitKHR.PERCENTAGE -> "VK_PERFORMANCE_COUNTER_UNIT_PERCENTAGE_KHR";
            case VkPerformanceCounterUnitKHR.VOLTS -> "VK_PERFORMANCE_COUNTER_UNIT_VOLTS_KHR";
            case VkPerformanceCounterUnitKHR.WATTS -> "VK_PERFORMANCE_COUNTER_UNIT_WATTS_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceCounterUnitKHR() {}
}

package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrPerformanceMetricsCounterUnitMETA.html"><code>XrPerformanceMetricsCounterUnitMETA</code></a>
public final class XrPerformanceMetricsCounterUnitMETA {
    public static final int GENERIC = 0x0;
    public static final int PERCENTAGE = 0x1;
    public static final int MILLISECONDS = 0x2;
    public static final int BYTES = 0x3;
    public static final int HERTZ = 0x4;

    public static String explain(@EnumType(XrPerformanceMetricsCounterUnitMETA.class) int value) {
        return switch (value) {
            case XrPerformanceMetricsCounterUnitMETA.BYTES -> "XR_PERFORMANCE_METRICS_COUNTER_UNIT_BYTES_META";
            case XrPerformanceMetricsCounterUnitMETA.GENERIC -> "XR_PERFORMANCE_METRICS_COUNTER_UNIT_GENERIC_META";
            case XrPerformanceMetricsCounterUnitMETA.HERTZ -> "XR_PERFORMANCE_METRICS_COUNTER_UNIT_HERTZ_META";
            case XrPerformanceMetricsCounterUnitMETA.MILLISECONDS -> "XR_PERFORMANCE_METRICS_COUNTER_UNIT_MILLISECONDS_META";
            case XrPerformanceMetricsCounterUnitMETA.PERCENTAGE -> "XR_PERFORMANCE_METRICS_COUNTER_UNIT_PERCENTAGE_META";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrPerformanceMetricsCounterUnitMETA() {}
}

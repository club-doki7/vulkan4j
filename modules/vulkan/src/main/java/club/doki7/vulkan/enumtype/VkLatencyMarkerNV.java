package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencyMarkerNV.html"><code>VkLatencyMarkerNV</code></a>
public final class VkLatencyMarkerNV {
    public static final int SIMULATION_START = 0x0;
    public static final int SIMULATION_END = 0x1;
    public static final int RENDERSUBMIT_START = 0x2;
    public static final int RENDERSUBMIT_END = 0x3;
    public static final int PRESENT_START = 0x4;
    public static final int PRESENT_END = 0x5;
    public static final int INPUT_SAMPLE = 0x6;
    public static final int TRIGGER_FLASH = 0x7;
    public static final int OUT_OF_BAND_RENDERSUBMIT_START = 0x8;
    public static final int OUT_OF_BAND_RENDERSUBMIT_END = 0x9;
    public static final int OUT_OF_BAND_PRESENT_START = 0xa;
    public static final int OUT_OF_BAND_PRESENT_END = 0xb;

    public static String explain(@EnumType(VkLatencyMarkerNV.class) int value) {
        return switch (value) {
            case VkLatencyMarkerNV.INPUT_SAMPLE -> "VK_LATENCY_MARKER_INPUT_SAMPLE_NV";
            case VkLatencyMarkerNV.OUT_OF_BAND_PRESENT_END -> "VK_LATENCY_MARKER_OUT_OF_BAND_PRESENT_END_NV";
            case VkLatencyMarkerNV.OUT_OF_BAND_PRESENT_START -> "VK_LATENCY_MARKER_OUT_OF_BAND_PRESENT_START_NV";
            case VkLatencyMarkerNV.OUT_OF_BAND_RENDERSUBMIT_END -> "VK_LATENCY_MARKER_OUT_OF_BAND_RENDERSUBMIT_END_NV";
            case VkLatencyMarkerNV.OUT_OF_BAND_RENDERSUBMIT_START -> "VK_LATENCY_MARKER_OUT_OF_BAND_RENDERSUBMIT_START_NV";
            case VkLatencyMarkerNV.PRESENT_END -> "VK_LATENCY_MARKER_PRESENT_END_NV";
            case VkLatencyMarkerNV.PRESENT_START -> "VK_LATENCY_MARKER_PRESENT_START_NV";
            case VkLatencyMarkerNV.RENDERSUBMIT_END -> "VK_LATENCY_MARKER_RENDERSUBMIT_END_NV";
            case VkLatencyMarkerNV.RENDERSUBMIT_START -> "VK_LATENCY_MARKER_RENDERSUBMIT_START_NV";
            case VkLatencyMarkerNV.SIMULATION_END -> "VK_LATENCY_MARKER_SIMULATION_END_NV";
            case VkLatencyMarkerNV.SIMULATION_START -> "VK_LATENCY_MARKER_SIMULATION_START_NV";
            case VkLatencyMarkerNV.TRIGGER_FLASH -> "VK_LATENCY_MARKER_TRIGGER_FLASH_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkLatencyMarkerNV() {}
}

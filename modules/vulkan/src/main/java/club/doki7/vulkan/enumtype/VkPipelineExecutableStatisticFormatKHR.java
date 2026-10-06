package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableStatisticFormatKHR.html"><code>VkPipelineExecutableStatisticFormatKHR</code></a>
public final class VkPipelineExecutableStatisticFormatKHR {
    public static final int BOOL32 = 0x0;
    public static final int INT64 = 0x1;
    public static final int UINT64 = 0x2;
    public static final int FLOAT64 = 0x3;

    public static String explain(@EnumType(VkPipelineExecutableStatisticFormatKHR.class) int value) {
        return switch (value) {
            case VkPipelineExecutableStatisticFormatKHR.BOOL32 -> "VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_BOOL32_KHR";
            case VkPipelineExecutableStatisticFormatKHR.FLOAT64 -> "VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_FLOAT64_KHR";
            case VkPipelineExecutableStatisticFormatKHR.INT64 -> "VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_INT64_KHR";
            case VkPipelineExecutableStatisticFormatKHR.UINT64 -> "VK_PIPELINE_EXECUTABLE_STATISTIC_FORMAT_UINT64_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineExecutableStatisticFormatKHR() {}
}

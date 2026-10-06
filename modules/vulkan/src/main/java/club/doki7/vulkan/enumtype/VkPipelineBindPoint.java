package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBindPoint.html"><code>VkPipelineBindPoint</code></a>
public final class VkPipelineBindPoint {
    public static final int GRAPHICS = 0x0;
    public static final int COMPUTE = 0x1;
    public static final int EXECUTION_GRAPH_AMDX = 0x3b9cd570;
    public static final int RAY_TRACING_KHR = 0x3b9d4e88;
    public static final int SUBPASS_SHADING_HUAWEI = 0x3ba06b6b;
    public static final int DATA_GRAPH_ARM = 0x3ba28678;

    public static String explain(@EnumType(VkPipelineBindPoint.class) int value) {
        return switch (value) {
            case VkPipelineBindPoint.COMPUTE -> "VK_PIPELINE_BIND_POINT_COMPUTE";
            case VkPipelineBindPoint.DATA_GRAPH_ARM -> "VK_PIPELINE_BIND_POINT_DATA_GRAPH_ARM";
            case VkPipelineBindPoint.EXECUTION_GRAPH_AMDX -> "VK_PIPELINE_BIND_POINT_EXECUTION_GRAPH_AMDX";
            case VkPipelineBindPoint.GRAPHICS -> "VK_PIPELINE_BIND_POINT_GRAPHICS";
            case VkPipelineBindPoint.RAY_TRACING_KHR -> "VK_PIPELINE_BIND_POINT_RAY_TRACING_KHR";
            case VkPipelineBindPoint.SUBPASS_SHADING_HUAWEI -> "VK_PIPELINE_BIND_POINT_SUBPASS_SHADING_HUAWEI";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineBindPoint() {}
}

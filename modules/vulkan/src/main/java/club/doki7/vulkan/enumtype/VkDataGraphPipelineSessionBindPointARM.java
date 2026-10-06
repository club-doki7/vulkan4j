package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionBindPointARM.html"><code>VkDataGraphPipelineSessionBindPointARM</code></a>
public final class VkDataGraphPipelineSessionBindPointARM {
    public static final int TRANSIENT = 0x0;
    public static final int OPTICAL_FLOW_CACHE = 0x3ba46ad9;
    public static final int NEURAL_ACCELERATOR_STATISTICS = 0x3ba51aa0;

    public static String explain(@EnumType(VkDataGraphPipelineSessionBindPointARM.class) int value) {
        return switch (value) {
            case VkDataGraphPipelineSessionBindPointARM.NEURAL_ACCELERATOR_STATISTICS -> "VK_DATA_GRAPH_PIPELINE_SESSION_BIND_POINT_NEURAL_ACCELERATOR_STATISTICS_ARM";
            case VkDataGraphPipelineSessionBindPointARM.OPTICAL_FLOW_CACHE -> "VK_DATA_GRAPH_PIPELINE_SESSION_BIND_POINT_OPTICAL_FLOW_CACHE_ARM";
            case VkDataGraphPipelineSessionBindPointARM.TRANSIENT -> "VK_DATA_GRAPH_PIPELINE_SESSION_BIND_POINT_TRANSIENT_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelineSessionBindPointARM() {}
}

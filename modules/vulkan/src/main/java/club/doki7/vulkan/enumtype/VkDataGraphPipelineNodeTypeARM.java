package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineNodeTypeARM.html"><code>VkDataGraphPipelineNodeTypeARM</code></a>
public final class VkDataGraphPipelineNodeTypeARM {
    public static final int OPTICAL_FLOW = 0x3ba46ad8;

    public static String explain(@EnumType(VkDataGraphPipelineNodeTypeARM.class) int value) {
        return switch (value) {
            case VkDataGraphPipelineNodeTypeARM.OPTICAL_FLOW -> "VK_DATA_GRAPH_PIPELINE_NODE_TYPE_OPTICAL_FLOW_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelineNodeTypeARM() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineNodeConnectionTypeARM.html"><code>VkDataGraphPipelineNodeConnectionTypeARM</code></a>
public final class VkDataGraphPipelineNodeConnectionTypeARM {
    public static final int OPTICAL_FLOW_INPUT = 0x3ba46ad8;
    public static final int OPTICAL_FLOW_REFERENCE = 0x3ba46ad9;
    public static final int OPTICAL_FLOW_HINT = 0x3ba46ada;
    public static final int OPTICAL_FLOW_FLOW_VECTOR = 0x3ba46adb;
    public static final int OPTICAL_FLOW_COST = 0x3ba46adc;

    public static String explain(@EnumType(VkDataGraphPipelineNodeConnectionTypeARM.class) int value) {
        return switch (value) {
            case VkDataGraphPipelineNodeConnectionTypeARM.OPTICAL_FLOW_COST -> "VK_DATA_GRAPH_PIPELINE_NODE_CONNECTION_TYPE_OPTICAL_FLOW_COST_ARM";
            case VkDataGraphPipelineNodeConnectionTypeARM.OPTICAL_FLOW_FLOW_VECTOR -> "VK_DATA_GRAPH_PIPELINE_NODE_CONNECTION_TYPE_OPTICAL_FLOW_FLOW_VECTOR_ARM";
            case VkDataGraphPipelineNodeConnectionTypeARM.OPTICAL_FLOW_HINT -> "VK_DATA_GRAPH_PIPELINE_NODE_CONNECTION_TYPE_OPTICAL_FLOW_HINT_ARM";
            case VkDataGraphPipelineNodeConnectionTypeARM.OPTICAL_FLOW_INPUT -> "VK_DATA_GRAPH_PIPELINE_NODE_CONNECTION_TYPE_OPTICAL_FLOW_INPUT_ARM";
            case VkDataGraphPipelineNodeConnectionTypeARM.OPTICAL_FLOW_REFERENCE -> "VK_DATA_GRAPH_PIPELINE_NODE_CONNECTION_TYPE_OPTICAL_FLOW_REFERENCE_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelineNodeConnectionTypeARM() {}
}

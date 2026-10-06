package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelinePropertyARM.html"><code>VkDataGraphPipelinePropertyARM</code></a>
public final class VkDataGraphPipelinePropertyARM {
    public static final int CREATION_LOG = 0x0;
    public static final int IDENTIFIER = 0x1;
    public static final int NEURAL_ACCELERATOR_DEBUG_DATABASE = 0x3ba51aa0;
    public static final int NEURAL_ACCELERATOR_STATISTICS_INFO = 0x3ba51aa1;

    public static String explain(@EnumType(VkDataGraphPipelinePropertyARM.class) int value) {
        return switch (value) {
            case VkDataGraphPipelinePropertyARM.CREATION_LOG -> "VK_DATA_GRAPH_PIPELINE_PROPERTY_CREATION_LOG_ARM";
            case VkDataGraphPipelinePropertyARM.IDENTIFIER -> "VK_DATA_GRAPH_PIPELINE_PROPERTY_IDENTIFIER_ARM";
            case VkDataGraphPipelinePropertyARM.NEURAL_ACCELERATOR_DEBUG_DATABASE -> "VK_DATA_GRAPH_PIPELINE_PROPERTY_NEURAL_ACCELERATOR_DEBUG_DATABASE_ARM";
            case VkDataGraphPipelinePropertyARM.NEURAL_ACCELERATOR_STATISTICS_INFO -> "VK_DATA_GRAPH_PIPELINE_PROPERTY_NEURAL_ACCELERATOR_STATISTICS_INFO_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelinePropertyARM() {}
}

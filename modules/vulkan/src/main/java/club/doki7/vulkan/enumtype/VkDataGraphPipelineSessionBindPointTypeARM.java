package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionBindPointTypeARM.html"><code>VkDataGraphPipelineSessionBindPointTypeARM</code></a>
public final class VkDataGraphPipelineSessionBindPointTypeARM {
    public static final int MEMORY = 0x0;

    public static String explain(@EnumType(VkDataGraphPipelineSessionBindPointTypeARM.class) int value) {
        return switch (value) {
            case VkDataGraphPipelineSessionBindPointTypeARM.MEMORY -> "VK_DATA_GRAPH_PIPELINE_SESSION_BIND_POINT_TYPE_MEMORY_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphPipelineSessionBindPointTypeARM() {}
}

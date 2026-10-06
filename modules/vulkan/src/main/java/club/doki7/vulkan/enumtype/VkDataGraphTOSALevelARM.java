package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphTOSALevelARM.html"><code>VkDataGraphTOSALevelARM</code></a>
public final class VkDataGraphTOSALevelARM {
    public static final int VK_DATA_GRAPH_TOSA_LEVEL_NONE = 0x0;
    public static final int VK_DATA_GRAPH_TOSA_LEVEL_8K = 0x1;

    public static String explain(@EnumType(VkDataGraphTOSALevelARM.class) int value) {
        return switch (value) {
            case VkDataGraphTOSALevelARM.VK_DATA_GRAPH_TOSA_LEVEL_8K -> "VK_DATA_GRAPH_TOSA_LEVEL_8K_ARM";
            case VkDataGraphTOSALevelARM.VK_DATA_GRAPH_TOSA_LEVEL_NONE -> "VK_DATA_GRAPH_TOSA_LEVEL_NONE_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphTOSALevelARM() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphModelCacheTypeQCOM.html"><code>VkDataGraphModelCacheTypeQCOM</code></a>
public final class VkDataGraphModelCacheTypeQCOM {
    public static final int GENERIC_BINARY = 0x0;

    public static String explain(@EnumType(VkDataGraphModelCacheTypeQCOM.class) int value) {
        return switch (value) {
            case VkDataGraphModelCacheTypeQCOM.GENERIC_BINARY -> "VK_DATA_GRAPH_MODEL_CACHE_TYPE_GENERIC_BINARY_QCOM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDataGraphModelCacheTypeQCOM() {}
}

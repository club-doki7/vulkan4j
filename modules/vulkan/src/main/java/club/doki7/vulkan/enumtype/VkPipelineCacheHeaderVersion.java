package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCacheHeaderVersion.html"><code>VkPipelineCacheHeaderVersion</code></a>
public final class VkPipelineCacheHeaderVersion {
    public static final int ONE = 0x1;
    public static final int DATA_GRAPH_QCOM = 0x3ba46308;

    public static String explain(@EnumType(VkPipelineCacheHeaderVersion.class) int value) {
        return switch (value) {
            case VkPipelineCacheHeaderVersion.DATA_GRAPH_QCOM -> "VK_PIPELINE_CACHE_HEADER_VERSION_DATA_GRAPH_QCOM";
            case VkPipelineCacheHeaderVersion.ONE -> "VK_PIPELINE_CACHE_HEADER_VERSION_ONE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineCacheHeaderVersion() {}
}

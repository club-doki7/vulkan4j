package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingLssIndexingModeNV.html"><code>VkRayTracingLssIndexingModeNV</code></a>
public final class VkRayTracingLssIndexingModeNV {
    public static final int LIST = 0x0;
    public static final int SUCCESSIVE = 0x1;

    public static String explain(@EnumType(VkRayTracingLssIndexingModeNV.class) int value) {
        return switch (value) {
            case VkRayTracingLssIndexingModeNV.LIST -> "VK_RAY_TRACING_LSS_INDEXING_MODE_LIST_NV";
            case VkRayTracingLssIndexingModeNV.SUCCESSIVE -> "VK_RAY_TRACING_LSS_INDEXING_MODE_SUCCESSIVE_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRayTracingLssIndexingModeNV() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpacityMicromapSpecialIndexKHR.html"><code>VkOpacityMicromapSpecialIndexKHR</code></a>
public final class VkOpacityMicromapSpecialIndexKHR {
    public static final int FULLY_TRANSPARENT = 0xffffffff;
    public static final int FULLY_OPAQUE = 0xfffffffe;
    public static final int FULLY_UNKNOWN_TRANSPARENT = 0xfffffffd;
    public static final int FULLY_UNKNOWN_OPAQUE = 0xfffffffc;
    public static final int CLUSTER_GEOMETRY_DISABLE_OPACITY_MICROMAP_NV = 0xfffffffb;

    public static String explain(@EnumType(VkOpacityMicromapSpecialIndexKHR.class) int value) {
        return switch (value) {
            case VkOpacityMicromapSpecialIndexKHR.CLUSTER_GEOMETRY_DISABLE_OPACITY_MICROMAP_NV -> "VK_OPACITY_MICROMAP_SPECIAL_INDEX_CLUSTER_GEOMETRY_DISABLE_OPACITY_MICROMAP_NV";
            case VkOpacityMicromapSpecialIndexKHR.FULLY_OPAQUE -> "VK_OPACITY_MICROMAP_SPECIAL_INDEX_FULLY_OPAQUE_KHR";
            case VkOpacityMicromapSpecialIndexKHR.FULLY_TRANSPARENT -> "VK_OPACITY_MICROMAP_SPECIAL_INDEX_FULLY_TRANSPARENT_KHR";
            case VkOpacityMicromapSpecialIndexKHR.FULLY_UNKNOWN_OPAQUE -> "VK_OPACITY_MICROMAP_SPECIAL_INDEX_FULLY_UNKNOWN_OPAQUE_KHR";
            case VkOpacityMicromapSpecialIndexKHR.FULLY_UNKNOWN_TRANSPARENT -> "VK_OPACITY_MICROMAP_SPECIAL_INDEX_FULLY_UNKNOWN_TRANSPARENT_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpacityMicromapSpecialIndexKHR() {}
}

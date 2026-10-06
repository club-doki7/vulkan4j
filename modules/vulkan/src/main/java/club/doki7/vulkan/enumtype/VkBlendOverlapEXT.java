package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlendOverlapEXT.html"><code>VkBlendOverlapEXT</code></a>
public final class VkBlendOverlapEXT {
    public static final int UNCORRELATED = 0x0;
    public static final int DISJOINT = 0x1;
    public static final int CONJOINT = 0x2;

    public static String explain(@EnumType(VkBlendOverlapEXT.class) int value) {
        return switch (value) {
            case VkBlendOverlapEXT.CONJOINT -> "VK_BLEND_OVERLAP_CONJOINT_EXT";
            case VkBlendOverlapEXT.DISJOINT -> "VK_BLEND_OVERLAP_DISJOINT_EXT";
            case VkBlendOverlapEXT.UNCORRELATED -> "VK_BLEND_OVERLAP_UNCORRELATED_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBlendOverlapEXT() {}
}

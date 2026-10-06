package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageTiling.html"><code>VkImageTiling</code></a>
public final class VkImageTiling {
    public static final int OPTIMAL = 0x0;
    public static final int LINEAR = 0x1;
    public static final int DRM_FORMAT_MODIFIER_EXT = 0x3b9d3330;

    public static String explain(@EnumType(VkImageTiling.class) int value) {
        return switch (value) {
            case VkImageTiling.DRM_FORMAT_MODIFIER_EXT -> "VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT";
            case VkImageTiling.LINEAR -> "VK_IMAGE_TILING_LINEAR";
            case VkImageTiling.OPTIMAL -> "VK_IMAGE_TILING_OPTIMAL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageTiling() {}
}

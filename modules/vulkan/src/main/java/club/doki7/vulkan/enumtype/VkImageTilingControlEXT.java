package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageTilingControlEXT.html"><code>VkImageTilingControlEXT</code></a>
public final class VkImageTilingControlEXT {
    public static final int DEFAULT = 0x0;
    public static final int MIN_SIZE = 0x1;
    public static final int MAX_PERFORMANCE = 0x2;

    public static String explain(@EnumType(VkImageTilingControlEXT.class) int value) {
        return switch (value) {
            case VkImageTilingControlEXT.DEFAULT -> "VK_IMAGE_TILING_CONTROL_DEFAULT_EXT";
            case VkImageTilingControlEXT.MAX_PERFORMANCE -> "VK_IMAGE_TILING_CONTROL_MAX_PERFORMANCE_EXT";
            case VkImageTilingControlEXT.MIN_SIZE -> "VK_IMAGE_TILING_CONTROL_MIN_SIZE_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageTilingControlEXT() {}
}

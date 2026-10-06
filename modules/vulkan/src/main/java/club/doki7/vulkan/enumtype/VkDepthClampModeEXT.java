package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthClampModeEXT.html"><code>VkDepthClampModeEXT</code></a>
public final class VkDepthClampModeEXT {
    public static final int VIEWPORT_RANGE = 0x0;
    public static final int USER_DEFINED_RANGE = 0x1;

    public static String explain(@EnumType(VkDepthClampModeEXT.class) int value) {
        return switch (value) {
            case VkDepthClampModeEXT.USER_DEFINED_RANGE -> "VK_DEPTH_CLAMP_MODE_USER_DEFINED_RANGE_EXT";
            case VkDepthClampModeEXT.VIEWPORT_RANGE -> "VK_DEPTH_CLAMP_MODE_VIEWPORT_RANGE_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDepthClampModeEXT() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBorderColor.html"><code>VkBorderColor</code></a>
public final class VkBorderColor {
    public static final int FLOAT_TRANSPARENT_BLACK = 0x0;
    public static final int INT_TRANSPARENT_BLACK = 0x1;
    public static final int FLOAT_OPAQUE_BLACK = 0x2;
    public static final int INT_OPAQUE_BLACK = 0x3;
    public static final int FLOAT_OPAQUE_WHITE = 0x4;
    public static final int INT_OPAQUE_WHITE = 0x5;
    public static final int FLOAT_CUSTOM_EXT = 0x3b9f2b1b;
    public static final int INT_CUSTOM_EXT = 0x3b9f2b1c;

    public static String explain(@EnumType(VkBorderColor.class) int value) {
        return switch (value) {
            case VkBorderColor.FLOAT_CUSTOM_EXT -> "VK_BORDER_COLOR_FLOAT_CUSTOM_EXT";
            case VkBorderColor.FLOAT_OPAQUE_BLACK -> "VK_BORDER_COLOR_FLOAT_OPAQUE_BLACK";
            case VkBorderColor.FLOAT_OPAQUE_WHITE -> "VK_BORDER_COLOR_FLOAT_OPAQUE_WHITE";
            case VkBorderColor.FLOAT_TRANSPARENT_BLACK -> "VK_BORDER_COLOR_FLOAT_TRANSPARENT_BLACK";
            case VkBorderColor.INT_CUSTOM_EXT -> "VK_BORDER_COLOR_INT_CUSTOM_EXT";
            case VkBorderColor.INT_OPAQUE_BLACK -> "VK_BORDER_COLOR_INT_OPAQUE_BLACK";
            case VkBorderColor.INT_OPAQUE_WHITE -> "VK_BORDER_COLOR_INT_OPAQUE_WHITE";
            case VkBorderColor.INT_TRANSPARENT_BLACK -> "VK_BORDER_COLOR_INT_TRANSPARENT_BLACK";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBorderColor() {}
}

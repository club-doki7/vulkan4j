package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPolygonMode.html"><code>VkPolygonMode</code></a>
public final class VkPolygonMode {
    public static final int FILL = 0x0;
    public static final int LINE = 0x1;
    public static final int POINT = 0x2;
    public static final int FILL_RECTANGLE_NV = 0x3b9d1fa8;

    public static String explain(@EnumType(VkPolygonMode.class) int value) {
        return switch (value) {
            case VkPolygonMode.FILL -> "VK_POLYGON_MODE_FILL";
            case VkPolygonMode.FILL_RECTANGLE_NV -> "VK_POLYGON_MODE_FILL_RECTANGLE_NV";
            case VkPolygonMode.LINE -> "VK_POLYGON_MODE_LINE";
            case VkPolygonMode.POINT -> "VK_POLYGON_MODE_POINT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPolygonMode() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLineRasterizationMode.html"><code>VkLineRasterizationMode</code></a>
public final class VkLineRasterizationMode {
    public static final int DEFAULT = 0x0;
    public static final int RECTANGULAR = 0x1;
    public static final int BRESENHAM = 0x2;
    public static final int RECTANGULAR_SMOOTH = 0x3;

    public static String explain(@EnumType(VkLineRasterizationMode.class) int value) {
        return switch (value) {
            case VkLineRasterizationMode.BRESENHAM -> "VK_LINE_RASTERIZATION_MODE_BRESENHAM";
            case VkLineRasterizationMode.DEFAULT -> "VK_LINE_RASTERIZATION_MODE_DEFAULT";
            case VkLineRasterizationMode.RECTANGULAR -> "VK_LINE_RASTERIZATION_MODE_RECTANGULAR";
            case VkLineRasterizationMode.RECTANGULAR_SMOOTH -> "VK_LINE_RASTERIZATION_MODE_RECTANGULAR_SMOOTH";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkLineRasterizationMode() {}
}

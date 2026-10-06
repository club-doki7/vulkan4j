package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewType.html"><code>VkImageViewType</code></a>
public final class VkImageViewType {
    public static final int _1D = 0x0;
    public static final int _2D = 0x1;
    public static final int _3D = 0x2;
    public static final int CUBE = 0x3;
    public static final int _1D_ARRAY = 0x4;
    public static final int _2D_ARRAY = 0x5;
    public static final int CUBE_ARRAY = 0x6;

    public static String explain(@EnumType(VkImageViewType.class) int value) {
        return switch (value) {
            case VkImageViewType._1D -> "VK_IMAGE_VIEW_TYPE_1D";
            case VkImageViewType._1D_ARRAY -> "VK_IMAGE_VIEW_TYPE_1D_ARRAY";
            case VkImageViewType._2D -> "VK_IMAGE_VIEW_TYPE_2D";
            case VkImageViewType._2D_ARRAY -> "VK_IMAGE_VIEW_TYPE_2D_ARRAY";
            case VkImageViewType._3D -> "VK_IMAGE_VIEW_TYPE_3D";
            case VkImageViewType.CUBE -> "VK_IMAGE_VIEW_TYPE_CUBE";
            case VkImageViewType.CUBE_ARRAY -> "VK_IMAGE_VIEW_TYPE_CUBE_ARRAY";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageViewType() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageType.html"><code>VkImageType</code></a>
public final class VkImageType {
    public static final int _1D = 0x0;
    public static final int _2D = 0x1;
    public static final int _3D = 0x2;

    public static String explain(@EnumType(VkImageType.class) int value) {
        return switch (value) {
            case VkImageType._1D -> "VK_IMAGE_TYPE_1D";
            case VkImageType._2D -> "VK_IMAGE_TYPE_2D";
            case VkImageType._3D -> "VK_IMAGE_TYPE_3D";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageType() {}
}

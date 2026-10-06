package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkComponentSwizzle.html"><code>VkComponentSwizzle</code></a>
public final class VkComponentSwizzle {
    public static final int IDENTITY = 0x0;
    public static final int ZERO = 0x1;
    public static final int ONE = 0x2;
    public static final int R = 0x3;
    public static final int G = 0x4;
    public static final int B = 0x5;
    public static final int A = 0x6;

    public static String explain(@EnumType(VkComponentSwizzle.class) int value) {
        return switch (value) {
            case VkComponentSwizzle.A -> "VK_COMPONENT_SWIZZLE_A";
            case VkComponentSwizzle.B -> "VK_COMPONENT_SWIZZLE_B";
            case VkComponentSwizzle.G -> "VK_COMPONENT_SWIZZLE_G";
            case VkComponentSwizzle.IDENTITY -> "VK_COMPONENT_SWIZZLE_IDENTITY";
            case VkComponentSwizzle.ONE -> "VK_COMPONENT_SWIZZLE_ONE";
            case VkComponentSwizzle.R -> "VK_COMPONENT_SWIZZLE_R";
            case VkComponentSwizzle.ZERO -> "VK_COMPONENT_SWIZZLE_ZERO";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkComponentSwizzle() {}
}

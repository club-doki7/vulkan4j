package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorTilingARM.html"><code>VkTensorTilingARM</code></a>
public final class VkTensorTilingARM {
    public static final int OPTIMAL = 0x0;
    public static final int LINEAR = 0x1;
    public static final int BRICK_16_WIDE = 0x3ba36908;
    public static final int BRICK_8_WIDE = 0x3ba36909;
    public static final int BRICK_4_WIDE = 0x3ba3690a;
    public static final int BLOCK_U_INTERLEAVED = 0x3ba3690b;
    public static final int BLOCK_U_INTERLEAVED_64K = 0x3ba3690c;

    public static String explain(@EnumType(VkTensorTilingARM.class) int value) {
        return switch (value) {
            case VkTensorTilingARM.BLOCK_U_INTERLEAVED_64K -> "VK_TENSOR_TILING_BLOCK_U_INTERLEAVED_64K_ARM";
            case VkTensorTilingARM.BLOCK_U_INTERLEAVED -> "VK_TENSOR_TILING_BLOCK_U_INTERLEAVED_ARM";
            case VkTensorTilingARM.BRICK_16_WIDE -> "VK_TENSOR_TILING_BRICK_16_WIDE_ARM";
            case VkTensorTilingARM.BRICK_4_WIDE -> "VK_TENSOR_TILING_BRICK_4_WIDE_ARM";
            case VkTensorTilingARM.BRICK_8_WIDE -> "VK_TENSOR_TILING_BRICK_8_WIDE_ARM";
            case VkTensorTilingARM.LINEAR -> "VK_TENSOR_TILING_LINEAR_ARM";
            case VkTensorTilingARM.OPTIMAL -> "VK_TENSOR_TILING_OPTIMAL_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTensorTilingARM() {}
}

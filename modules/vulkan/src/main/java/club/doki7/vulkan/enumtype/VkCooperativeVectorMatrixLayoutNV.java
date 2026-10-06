package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCooperativeVectorMatrixLayoutNV.html"><code>VkCooperativeVectorMatrixLayoutNV</code></a>
public final class VkCooperativeVectorMatrixLayoutNV {
    public static final int ROW_MAJOR = 0x0;
    public static final int COLUMN_MAJOR = 0x1;
    public static final int INFERENCING_OPTIMAL = 0x2;
    public static final int TRAINING_OPTIMAL = 0x3;

    public static String explain(@EnumType(VkCooperativeVectorMatrixLayoutNV.class) int value) {
        return switch (value) {
            case VkCooperativeVectorMatrixLayoutNV.COLUMN_MAJOR -> "VK_COOPERATIVE_VECTOR_MATRIX_LAYOUT_COLUMN_MAJOR_NV";
            case VkCooperativeVectorMatrixLayoutNV.INFERENCING_OPTIMAL -> "VK_COOPERATIVE_VECTOR_MATRIX_LAYOUT_INFERENCING_OPTIMAL_NV";
            case VkCooperativeVectorMatrixLayoutNV.ROW_MAJOR -> "VK_COOPERATIVE_VECTOR_MATRIX_LAYOUT_ROW_MAJOR_NV";
            case VkCooperativeVectorMatrixLayoutNV.TRAINING_OPTIMAL -> "VK_COOPERATIVE_VECTOR_MATRIX_LAYOUT_TRAINING_OPTIMAL_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCooperativeVectorMatrixLayoutNV() {}
}

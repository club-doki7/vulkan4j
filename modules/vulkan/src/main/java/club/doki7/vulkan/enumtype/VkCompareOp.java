package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCompareOp.html"><code>VkCompareOp</code></a>
public final class VkCompareOp {
    public static final int NEVER = 0x0;
    public static final int LESS = 0x1;
    public static final int EQUAL = 0x2;
    public static final int LESS_OR_EQUAL = 0x3;
    public static final int GREATER = 0x4;
    public static final int NOT_EQUAL = 0x5;
    public static final int GREATER_OR_EQUAL = 0x6;
    public static final int ALWAYS = 0x7;

    public static String explain(@EnumType(VkCompareOp.class) int value) {
        return switch (value) {
            case VkCompareOp.ALWAYS -> "VK_COMPARE_OP_ALWAYS";
            case VkCompareOp.EQUAL -> "VK_COMPARE_OP_EQUAL";
            case VkCompareOp.GREATER -> "VK_COMPARE_OP_GREATER";
            case VkCompareOp.GREATER_OR_EQUAL -> "VK_COMPARE_OP_GREATER_OR_EQUAL";
            case VkCompareOp.LESS -> "VK_COMPARE_OP_LESS";
            case VkCompareOp.LESS_OR_EQUAL -> "VK_COMPARE_OP_LESS_OR_EQUAL";
            case VkCompareOp.NEVER -> "VK_COMPARE_OP_NEVER";
            case VkCompareOp.NOT_EQUAL -> "VK_COMPARE_OP_NOT_EQUAL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCompareOp() {}
}

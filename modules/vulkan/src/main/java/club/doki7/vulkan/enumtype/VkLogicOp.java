package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLogicOp.html"><code>VkLogicOp</code></a>
public final class VkLogicOp {
    public static final int CLEAR = 0x0;
    public static final int AND = 0x1;
    public static final int AND_REVERSE = 0x2;
    public static final int COPY = 0x3;
    public static final int AND_INVERTED = 0x4;
    public static final int NO_OP = 0x5;
    public static final int XOR = 0x6;
    public static final int OR = 0x7;
    public static final int NOR = 0x8;
    public static final int EQUIVALENT = 0x9;
    public static final int INVERT = 0xa;
    public static final int OR_REVERSE = 0xb;
    public static final int COPY_INVERTED = 0xc;
    public static final int OR_INVERTED = 0xd;
    public static final int NAND = 0xe;
    public static final int SET = 0xf;

    public static String explain(@EnumType(VkLogicOp.class) int value) {
        return switch (value) {
            case VkLogicOp.AND -> "VK_LOGIC_OP_AND";
            case VkLogicOp.AND_INVERTED -> "VK_LOGIC_OP_AND_INVERTED";
            case VkLogicOp.AND_REVERSE -> "VK_LOGIC_OP_AND_REVERSE";
            case VkLogicOp.CLEAR -> "VK_LOGIC_OP_CLEAR";
            case VkLogicOp.COPY -> "VK_LOGIC_OP_COPY";
            case VkLogicOp.COPY_INVERTED -> "VK_LOGIC_OP_COPY_INVERTED";
            case VkLogicOp.EQUIVALENT -> "VK_LOGIC_OP_EQUIVALENT";
            case VkLogicOp.INVERT -> "VK_LOGIC_OP_INVERT";
            case VkLogicOp.NAND -> "VK_LOGIC_OP_NAND";
            case VkLogicOp.NOR -> "VK_LOGIC_OP_NOR";
            case VkLogicOp.NO_OP -> "VK_LOGIC_OP_NO_OP";
            case VkLogicOp.OR -> "VK_LOGIC_OP_OR";
            case VkLogicOp.OR_INVERTED -> "VK_LOGIC_OP_OR_INVERTED";
            case VkLogicOp.OR_REVERSE -> "VK_LOGIC_OP_OR_REVERSE";
            case VkLogicOp.SET -> "VK_LOGIC_OP_SET";
            case VkLogicOp.XOR -> "VK_LOGIC_OP_XOR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkLogicOp() {}
}

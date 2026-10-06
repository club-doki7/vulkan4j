package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStencilOp.html"><code>VkStencilOp</code></a>
public final class VkStencilOp {
    public static final int KEEP = 0x0;
    public static final int ZERO = 0x1;
    public static final int REPLACE = 0x2;
    public static final int INCREMENT_AND_CLAMP = 0x3;
    public static final int DECREMENT_AND_CLAMP = 0x4;
    public static final int INVERT = 0x5;
    public static final int INCREMENT_AND_WRAP = 0x6;
    public static final int DECREMENT_AND_WRAP = 0x7;

    public static String explain(@EnumType(VkStencilOp.class) int value) {
        return switch (value) {
            case VkStencilOp.DECREMENT_AND_CLAMP -> "VK_STENCIL_OP_DECREMENT_AND_CLAMP";
            case VkStencilOp.DECREMENT_AND_WRAP -> "VK_STENCIL_OP_DECREMENT_AND_WRAP";
            case VkStencilOp.INCREMENT_AND_CLAMP -> "VK_STENCIL_OP_INCREMENT_AND_CLAMP";
            case VkStencilOp.INCREMENT_AND_WRAP -> "VK_STENCIL_OP_INCREMENT_AND_WRAP";
            case VkStencilOp.INVERT -> "VK_STENCIL_OP_INVERT";
            case VkStencilOp.KEEP -> "VK_STENCIL_OP_KEEP";
            case VkStencilOp.REPLACE -> "VK_STENCIL_OP_REPLACE";
            case VkStencilOp.ZERO -> "VK_STENCIL_OP_ZERO";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkStencilOp() {}
}

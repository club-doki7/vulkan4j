package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentLoadOp.html"><code>VkAttachmentLoadOp</code></a>
public final class VkAttachmentLoadOp {
    public static final int LOAD = 0x0;
    public static final int CLEAR = 0x1;
    public static final int DONT_CARE = 0x2;
    public static final int NONE = 0x3ba0e480;

    public static String explain(@EnumType(VkAttachmentLoadOp.class) int value) {
        return switch (value) {
            case VkAttachmentLoadOp.CLEAR -> "VK_ATTACHMENT_LOAD_OP_CLEAR";
            case VkAttachmentLoadOp.DONT_CARE -> "VK_ATTACHMENT_LOAD_OP_DONT_CARE";
            case VkAttachmentLoadOp.LOAD -> "VK_ATTACHMENT_LOAD_OP_LOAD";
            case VkAttachmentLoadOp.NONE -> "VK_ATTACHMENT_LOAD_OP_NONE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAttachmentLoadOp() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentStoreOp.html"><code>VkAttachmentStoreOp</code></a>
public final class VkAttachmentStoreOp {
    public static final int STORE = 0x0;
    public static final int DONT_CARE = 0x1;
    public static final int NONE = 0x3b9f61c8;

    public static String explain(@EnumType(VkAttachmentStoreOp.class) int value) {
        return switch (value) {
            case VkAttachmentStoreOp.DONT_CARE -> "VK_ATTACHMENT_STORE_OP_DONT_CARE";
            case VkAttachmentStoreOp.NONE -> "VK_ATTACHMENT_STORE_OP_NONE";
            case VkAttachmentStoreOp.STORE -> "VK_ATTACHMENT_STORE_OP_STORE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAttachmentStoreOp() {}
}

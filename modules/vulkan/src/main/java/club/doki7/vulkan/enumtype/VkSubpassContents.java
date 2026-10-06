package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassContents.html"><code>VkSubpassContents</code></a>
public final class VkSubpassContents {
    public static final int INLINE = 0x0;
    public static final int SECONDARY_COMMAND_BUFFERS = 0x1;
    public static final int INLINE_AND_SECONDARY_COMMAND_BUFFERS_KHR = 0x3ba1abb8;

    public static String explain(@EnumType(VkSubpassContents.class) int value) {
        return switch (value) {
            case VkSubpassContents.INLINE -> "VK_SUBPASS_CONTENTS_INLINE";
            case VkSubpassContents.INLINE_AND_SECONDARY_COMMAND_BUFFERS_KHR -> "VK_SUBPASS_CONTENTS_INLINE_AND_SECONDARY_COMMAND_BUFFERS_KHR";
            case VkSubpassContents.SECONDARY_COMMAND_BUFFERS -> "VK_SUBPASS_CONTENTS_SECONDARY_COMMAND_BUFFERS";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSubpassContents() {}
}

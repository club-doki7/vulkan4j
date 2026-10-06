package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentDescriptionFlags.html"><code>VkAttachmentDescriptionFlags</code></a>
public final class VkAttachmentDescriptionFlags {
    public static final int MAY_ALIAS = 0x1;
    public static final int RESOLVE_ENABLE_TRANSFER_FUNCTION_KHR = 0x4;
    public static final int RESOLVE_SKIP_TRANSFER_FUNCTION_KHR = 0x2;

    public static String explain(@Bitmask(VkAttachmentDescriptionFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & MAY_ALIAS) != 0) {
            detectedFlagBits.add("VK_ATTACHMENT_DESCRIPTION_MAY_ALIAS_BIT");
        }
        if ((flags & RESOLVE_ENABLE_TRANSFER_FUNCTION_KHR) != 0) {
            detectedFlagBits.add("VK_ATTACHMENT_DESCRIPTION_RESOLVE_ENABLE_TRANSFER_FUNCTION_BIT_KHR");
        }
        if ((flags & RESOLVE_SKIP_TRANSFER_FUNCTION_KHR) != 0) {
            detectedFlagBits.add("VK_ATTACHMENT_DESCRIPTION_RESOLVE_SKIP_TRANSFER_FUNCTION_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAttachmentDescriptionFlags() {}
}

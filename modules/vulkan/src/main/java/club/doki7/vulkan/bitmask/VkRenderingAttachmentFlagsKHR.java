package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingAttachmentFlagsKHR.html"><code>VkRenderingAttachmentFlagsKHR</code></a>
public final class VkRenderingAttachmentFlagsKHR {
    public static final int INPUT_ATTACHMENT_FEEDBACK = 0x1;
    public static final int RESOLVE_ENABLE_TRANSFER_FUNCTION = 0x4;
    public static final int RESOLVE_SKIP_TRANSFER_FUNCTION = 0x2;

    public static String explain(@Bitmask(VkRenderingAttachmentFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INPUT_ATTACHMENT_FEEDBACK) != 0) {
            detectedFlagBits.add("VK_RENDERING_ATTACHMENT_INPUT_ATTACHMENT_FEEDBACK_BIT_KHR");
        }
        if ((flags & RESOLVE_ENABLE_TRANSFER_FUNCTION) != 0) {
            detectedFlagBits.add("VK_RENDERING_ATTACHMENT_RESOLVE_ENABLE_TRANSFER_FUNCTION_BIT_KHR");
        }
        if ((flags & RESOLVE_SKIP_TRANSFER_FUNCTION) != 0) {
            detectedFlagBits.add("VK_RENDERING_ATTACHMENT_RESOLVE_SKIP_TRANSFER_FUNCTION_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRenderingAttachmentFlagsKHR() {}
}

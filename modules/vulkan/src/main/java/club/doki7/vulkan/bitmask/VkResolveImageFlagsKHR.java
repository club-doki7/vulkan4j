package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkResolveImageFlagsKHR.html"><code>VkResolveImageFlagsKHR</code></a>
public final class VkResolveImageFlagsKHR {
    public static final int ENABLE_TRANSFER_FUNCTION = 0x2;
    public static final int SKIP_TRANSFER_FUNCTION = 0x1;

    public static String explain(@Bitmask(VkResolveImageFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ENABLE_TRANSFER_FUNCTION) != 0) {
            detectedFlagBits.add("VK_RESOLVE_IMAGE_ENABLE_TRANSFER_FUNCTION_BIT_KHR");
        }
        if ((flags & SKIP_TRANSFER_FUNCTION) != 0) {
            detectedFlagBits.add("VK_RESOLVE_IMAGE_SKIP_TRANSFER_FUNCTION_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkResolveImageFlagsKHR() {}
}

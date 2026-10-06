package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCapabilityFlagsKHR.html"><code>VkVideoCapabilityFlagsKHR</code></a>
public final class VkVideoCapabilityFlagsKHR {
    public static final int PROTECTED_CONTENT = 0x1;
    public static final int SEPARATE_REFERENCE_IMAGES = 0x2;

    public static String explain(@Bitmask(VkVideoCapabilityFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & PROTECTED_CONTENT) != 0) {
            detectedFlagBits.add("VK_VIDEO_CAPABILITY_PROTECTED_CONTENT_BIT_KHR");
        }
        if ((flags & SEPARATE_REFERENCE_IMAGES) != 0) {
            detectedFlagBits.add("VK_VIDEO_CAPABILITY_SEPARATE_REFERENCE_IMAGES_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoCapabilityFlagsKHR() {}
}

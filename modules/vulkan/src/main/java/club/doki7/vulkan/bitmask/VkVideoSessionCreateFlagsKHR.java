package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionCreateFlagsKHR.html"><code>VkVideoSessionCreateFlagsKHR</code></a>
public final class VkVideoSessionCreateFlagsKHR {
    public static final int ALLOW_ENCODE_EMPHASIS_MAP = 0x10;
    public static final int ALLOW_ENCODE_PARAMETER_OPTIMIZATIONS = 0x2;
    public static final int ALLOW_ENCODE_QUANTIZATION_DELTA_MAP = 0x8;
    public static final int INLINE_QUERIES = 0x4;
    public static final int INLINE_SESSION_PARAMETERS = 0x20;
    public static final int PROTECTED_CONTENT = 0x1;

    public static String explain(@Bitmask(VkVideoSessionCreateFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_ENCODE_EMPHASIS_MAP) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_ALLOW_ENCODE_EMPHASIS_MAP_BIT_KHR");
        }
        if ((flags & ALLOW_ENCODE_PARAMETER_OPTIMIZATIONS) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_ALLOW_ENCODE_PARAMETER_OPTIMIZATIONS_BIT_KHR");
        }
        if ((flags & ALLOW_ENCODE_QUANTIZATION_DELTA_MAP) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_ALLOW_ENCODE_QUANTIZATION_DELTA_MAP_BIT_KHR");
        }
        if ((flags & INLINE_QUERIES) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_INLINE_QUERIES_BIT_KHR");
        }
        if ((flags & INLINE_SESSION_PARAMETERS) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_INLINE_SESSION_PARAMETERS_BIT_KHR");
        }
        if ((flags & PROTECTED_CONTENT) != 0) {
            detectedFlagBits.add("VK_VIDEO_SESSION_CREATE_PROTECTED_CONTENT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoSessionCreateFlagsKHR() {}
}

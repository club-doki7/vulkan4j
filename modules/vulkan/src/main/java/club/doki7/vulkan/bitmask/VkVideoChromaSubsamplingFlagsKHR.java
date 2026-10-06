package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoChromaSubsamplingFlagsKHR.html"><code>VkVideoChromaSubsamplingFlagsKHR</code></a>
public final class VkVideoChromaSubsamplingFlagsKHR {
    public static final int _420 = 0x2;
    public static final int _422 = 0x4;
    public static final int _444 = 0x8;
    public static final int INVALID = 0x0;
    public static final int MONOCHROME = 0x1;

    public static String explain(@Bitmask(VkVideoChromaSubsamplingFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _420) != 0) {
            detectedFlagBits.add("VK_VIDEO_CHROMA_SUBSAMPLING_420_BIT_KHR");
        }
        if ((flags & _422) != 0) {
            detectedFlagBits.add("VK_VIDEO_CHROMA_SUBSAMPLING_422_BIT_KHR");
        }
        if ((flags & _444) != 0) {
            detectedFlagBits.add("VK_VIDEO_CHROMA_SUBSAMPLING_444_BIT_KHR");
        }
        if ((flags & INVALID) != 0) {
            detectedFlagBits.add("VK_VIDEO_CHROMA_SUBSAMPLING_INVALID_KHR");
        }
        if ((flags & MONOCHROME) != 0) {
            detectedFlagBits.add("VK_VIDEO_CHROMA_SUBSAMPLING_MONOCHROME_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoChromaSubsamplingFlagsKHR() {}
}

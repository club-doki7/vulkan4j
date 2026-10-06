package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbRangeCompressionFlagsVALVE.html"><code>VkVideoEncodeRgbRangeCompressionFlagsVALVE</code></a>
public final class VkVideoEncodeRgbRangeCompressionFlagsVALVE {
    public static final int FULL_RANGE = 0x1;
    public static final int NARROW_RANGE = 0x2;

    public static String explain(@Bitmask(VkVideoEncodeRgbRangeCompressionFlagsVALVE.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FULL_RANGE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_RANGE_COMPRESSION_FULL_RANGE_BIT_VALVE");
        }
        if ((flags & NARROW_RANGE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_RANGE_COMPRESSION_NARROW_RANGE_BIT_VALVE");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeRgbRangeCompressionFlagsVALVE() {}
}

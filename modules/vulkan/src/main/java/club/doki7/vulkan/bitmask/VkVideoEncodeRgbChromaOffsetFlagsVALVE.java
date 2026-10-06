package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbChromaOffsetFlagsVALVE.html"><code>VkVideoEncodeRgbChromaOffsetFlagsVALVE</code></a>
public final class VkVideoEncodeRgbChromaOffsetFlagsVALVE {
    public static final int COSITED_EVEN = 0x1;
    public static final int MIDPOINT = 0x2;

    public static String explain(@Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & COSITED_EVEN) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_CHROMA_OFFSET_COSITED_EVEN_BIT_VALVE");
        }
        if ((flags & MIDPOINT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_CHROMA_OFFSET_MIDPOINT_BIT_VALVE");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeRgbChromaOffsetFlagsVALVE() {}
}

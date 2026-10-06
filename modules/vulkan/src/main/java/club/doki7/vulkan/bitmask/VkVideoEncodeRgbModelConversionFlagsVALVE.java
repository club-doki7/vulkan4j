package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbModelConversionFlagsVALVE.html"><code>VkVideoEncodeRgbModelConversionFlagsVALVE</code></a>
public final class VkVideoEncodeRgbModelConversionFlagsVALVE {
    public static final int RGB_IDENTITY = 0x1;
    public static final int YCBCR_2020 = 0x10;
    public static final int YCBCR_601 = 0x8;
    public static final int YCBCR_709 = 0x4;
    public static final int YCBCR_IDENTITY = 0x2;

    public static String explain(@Bitmask(VkVideoEncodeRgbModelConversionFlagsVALVE.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & RGB_IDENTITY) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_MODEL_CONVERSION_RGB_IDENTITY_BIT_VALVE");
        }
        if ((flags & YCBCR_2020) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_MODEL_CONVERSION_YCBCR_2020_BIT_VALVE");
        }
        if ((flags & YCBCR_601) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_MODEL_CONVERSION_YCBCR_601_BIT_VALVE");
        }
        if ((flags & YCBCR_709) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_MODEL_CONVERSION_YCBCR_709_BIT_VALVE");
        }
        if ((flags & YCBCR_IDENTITY) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_RGB_MODEL_CONVERSION_YCBCR_IDENTITY_BIT_VALVE");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeRgbModelConversionFlagsVALVE() {}
}

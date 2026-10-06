package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeFeedbackFlagsKHR.html"><code>VkVideoEncodeFeedbackFlagsKHR</code></a>
public final class VkVideoEncodeFeedbackFlagsKHR {
    public static final int AVERAGE_QUANTIZATION = 0x8;
    public static final int BITSTREAM_BUFFER_OFFSET = 0x1;
    public static final int BITSTREAM_BYTES_WRITTEN = 0x2;
    public static final int BITSTREAM_HAS_OVERRIDES = 0x4;
    public static final int INTER_PIXELS = 0x80;
    public static final int INTRA_PIXELS = 0x40;
    public static final int MAX_QUANTIZATION = 0x20;
    public static final int MIN_QUANTIZATION = 0x10;
    public static final int PICTURE_PARTITION_COUNT = 0x200;
    public static final int SKIPPED_PIXELS = 0x100;

    public static String explain(@Bitmask(VkVideoEncodeFeedbackFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & AVERAGE_QUANTIZATION) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_AVERAGE_QUANTIZATION_BIT_KHR");
        }
        if ((flags & BITSTREAM_BUFFER_OFFSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_BITSTREAM_BUFFER_OFFSET_BIT_KHR");
        }
        if ((flags & BITSTREAM_BYTES_WRITTEN) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_BITSTREAM_BYTES_WRITTEN_BIT_KHR");
        }
        if ((flags & BITSTREAM_HAS_OVERRIDES) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_BITSTREAM_HAS_OVERRIDES_BIT_KHR");
        }
        if ((flags & INTER_PIXELS) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_INTER_PIXELS_BIT_KHR");
        }
        if ((flags & INTRA_PIXELS) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_INTRA_PIXELS_BIT_KHR");
        }
        if ((flags & MAX_QUANTIZATION) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_MAX_QUANTIZATION_BIT_KHR");
        }
        if ((flags & MIN_QUANTIZATION) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_MIN_QUANTIZATION_BIT_KHR");
        }
        if ((flags & PICTURE_PARTITION_COUNT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_PICTURE_PARTITION_COUNT_BIT_KHR");
        }
        if ((flags & SKIPPED_PIXELS) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_FEEDBACK_SKIPPED_PIXELS_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeFeedbackFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodePerPartitionFeedbackFlagsKHR.html"><code>VkVideoEncodePerPartitionFeedbackFlagsKHR</code></a>
public final class VkVideoEncodePerPartitionFeedbackFlagsKHR {
    public static final int BITSTREAM_BUFFER_OFFSET = 0x2;
    public static final int BITSTREAM_BYTES_WRITTEN = 0x4;
    public static final int STATUS = 0x1;

    public static String explain(@Bitmask(VkVideoEncodePerPartitionFeedbackFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & BITSTREAM_BUFFER_OFFSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_PER_PARTITION_FEEDBACK_BITSTREAM_BUFFER_OFFSET_BIT_KHR");
        }
        if ((flags & BITSTREAM_BYTES_WRITTEN) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_PER_PARTITION_FEEDBACK_BITSTREAM_BYTES_WRITTEN_BIT_KHR");
        }
        if ((flags & STATUS) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_PER_PARTITION_FEEDBACK_STATUS_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodePerPartitionFeedbackFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeIntraRefreshModeFlagsKHR.html"><code>VkVideoEncodeIntraRefreshModeFlagsKHR</code></a>
public final class VkVideoEncodeIntraRefreshModeFlagsKHR {
    public static final int BLOCK_BASED = 0x2;
    public static final int BLOCK_COLUMN_BASED = 0x8;
    public static final int BLOCK_ROW_BASED = 0x4;
    public static final int NONE = 0x0;
    public static final int PER_PICTURE_PARTITION = 0x1;

    public static String explain(@Bitmask(VkVideoEncodeIntraRefreshModeFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & BLOCK_BASED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_MODE_BLOCK_BASED_BIT_KHR");
        }
        if ((flags & BLOCK_COLUMN_BASED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_MODE_BLOCK_COLUMN_BASED_BIT_KHR");
        }
        if ((flags & BLOCK_ROW_BASED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_MODE_BLOCK_ROW_BASED_BIT_KHR");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_MODE_NONE_KHR");
        }
        if ((flags & PER_PICTURE_PARTITION) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_INTRA_REFRESH_MODE_PER_PICTURE_PARTITION_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeIntraRefreshModeFlagsKHR() {}
}

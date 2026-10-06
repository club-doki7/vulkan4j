package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1SuperblockSizeFlagsKHR.html"><code>VkVideoEncodeAV1SuperblockSizeFlagsKHR</code></a>
public final class VkVideoEncodeAV1SuperblockSizeFlagsKHR {
    public static final int VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_128 = 0x2;
    public static final int VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_64 = 0x1;

    public static String explain(@Bitmask(VkVideoEncodeAV1SuperblockSizeFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_128) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_128_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_64) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_AV1_SUPERBLOCK_SIZE_64_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1SuperblockSizeFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265TransformBlockSizeFlagsKHR.html"><code>VkVideoEncodeH265TransformBlockSizeFlagsKHR</code></a>
public final class VkVideoEncodeH265TransformBlockSizeFlagsKHR {
    public static final int VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_16 = 0x4;
    public static final int VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_32 = 0x8;
    public static final int VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_4 = 0x1;
    public static final int VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_8 = 0x2;

    public static String explain(@Bitmask(VkVideoEncodeH265TransformBlockSizeFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_16) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_16_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_32) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_32_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_4) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_4_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_8) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_TRANSFORM_BLOCK_SIZE_8_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeH265TransformBlockSizeFlagsKHR() {}
}

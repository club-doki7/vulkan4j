package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264PictureLayoutFlagsKHR.html"><code>VkVideoDecodeH264PictureLayoutFlagsKHR</code></a>
public final class VkVideoDecodeH264PictureLayoutFlagsKHR {
    public static final int VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_INTERLEAVED_LINES = 0x1;
    public static final int VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_SEPARATE_PLANES = 0x2;
    public static final int VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_PROGRESSIVE = 0x0;

    public static String explain(@Bitmask(VkVideoDecodeH264PictureLayoutFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_INTERLEAVED_LINES) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_INTERLEAVED_LINES_BIT_KHR");
        }
        if ((flags & VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_SEPARATE_PLANES) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_INTERLACED_SEPARATE_PLANES_BIT_KHR");
        }
        if ((flags & VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_PROGRESSIVE) != 0) {
            detectedFlagBits.add("VK_VIDEO_DECODE_H264_PICTURE_LAYOUT_PROGRESSIVE_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoDecodeH264PictureLayoutFlagsKHR() {}
}

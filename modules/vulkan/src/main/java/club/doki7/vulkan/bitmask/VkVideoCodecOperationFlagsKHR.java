package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCodecOperationFlagsKHR.html"><code>VkVideoCodecOperationFlagsKHR</code></a>
public final class VkVideoCodecOperationFlagsKHR {
    public static final int DECODE_AV1 = 0x4;
    public static final int DECODE_H264 = 0x1;
    public static final int DECODE_H265 = 0x2;
    public static final int DECODE_VP9 = 0x8;
    public static final int ENCODE_AV1 = 0x40000;
    public static final int ENCODE_H264 = 0x10000;
    public static final int ENCODE_H265 = 0x20000;
    public static final int NONE = 0x0;

    public static String explain(@Bitmask(VkVideoCodecOperationFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DECODE_AV1) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_DECODE_AV1_BIT_KHR");
        }
        if ((flags & DECODE_H264) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_DECODE_H264_BIT_KHR");
        }
        if ((flags & DECODE_H265) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_DECODE_H265_BIT_KHR");
        }
        if ((flags & DECODE_VP9) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_DECODE_VP9_BIT_KHR");
        }
        if ((flags & ENCODE_AV1) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_ENCODE_AV1_BIT_KHR");
        }
        if ((flags & ENCODE_H264) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_ENCODE_H264_BIT_KHR");
        }
        if ((flags & ENCODE_H265) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_ENCODE_H265_BIT_KHR");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_VIDEO_CODEC_OPERATION_NONE_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoCodecOperationFlagsKHR() {}
}

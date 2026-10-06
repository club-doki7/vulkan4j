package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageUsageFlags2KHR.html"><code>VkImageUsageFlags2KHR</code></a>
public final class VkImageUsageFlags2KHR {
    public static final long ATTACHMENT_FEEDBACK_LOOP_EXT = 0x80000L;
    public static final long COLOR_ATTACHMENT = 0x10L;
    public static final long DEPTH_STENCIL_ATTACHMENT = 0x20L;
    public static final long FRAGMENT_DENSITY_MAP_EXT = 0x200L;
    public static final long FRAGMENT_SHADING_RATE_ATTACHMENT = 0x100L;
    public static final long HOST_TRANSFER = 0x400000L;
    public static final long INPUT_ATTACHMENT = 0x80L;
    public static final long INVOCATION_MASK_HUAWEI = 0x40000L;
    public static final long SAMPLED = 0x4L;
    public static final long SAMPLE_BLOCK_MATCH_QCOM = 0x200000L;
    public static final long SAMPLE_WEIGHT_QCOM = 0x100000L;
    public static final long STORAGE = 0x8L;
    public static final long TENSOR_ALIASING_ARM = 0x800000L;
    public static final long TILE_MEMORY_QCOM = 0x8000000L;
    public static final long TRANSFER_DST = 0x2L;
    public static final long TRANSFER_SRC = 0x1L;
    public static final long TRANSIENT_ATTACHMENT = 0x40L;
    public static final long VIDEO_DECODE_DPB = 0x1000L;
    public static final long VIDEO_DECODE_DST = 0x400L;
    public static final long VIDEO_DECODE_SRC = 0x800L;
    public static final long VIDEO_ENCODE_DPB = 0x8000L;
    public static final long VIDEO_ENCODE_DST = 0x2000L;
    public static final long VIDEO_ENCODE_EMPHASIS_MAP = 0x4000000L;
    public static final long VIDEO_ENCODE_QUANTIZATION_DELTA_MAP = 0x2000000L;
    public static final long VIDEO_ENCODE_SRC = 0x4000L;

    public static String explain(@Bitmask(VkImageUsageFlags2KHR.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ATTACHMENT_FEEDBACK_LOOP_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_ATTACHMENT_FEEDBACK_LOOP_BIT_EXT");
        }
        if ((flags & COLOR_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_COLOR_ATTACHMENT_BIT_KHR");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_DEPTH_STENCIL_ATTACHMENT_BIT_KHR");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_FRAGMENT_DENSITY_MAP_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & HOST_TRANSFER) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_HOST_TRANSFER_BIT_KHR");
        }
        if ((flags & INPUT_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_INPUT_ATTACHMENT_BIT_KHR");
        }
        if ((flags & INVOCATION_MASK_HUAWEI) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_INVOCATION_MASK_BIT_HUAWEI");
        }
        if ((flags & SAMPLED) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_SAMPLED_BIT_KHR");
        }
        if ((flags & SAMPLE_BLOCK_MATCH_QCOM) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_SAMPLE_BLOCK_MATCH_BIT_QCOM");
        }
        if ((flags & SAMPLE_WEIGHT_QCOM) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_SAMPLE_WEIGHT_BIT_QCOM");
        }
        if ((flags & STORAGE) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_STORAGE_BIT_KHR");
        }
        if ((flags & TENSOR_ALIASING_ARM) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_TENSOR_ALIASING_BIT_ARM");
        }
        if ((flags & TILE_MEMORY_QCOM) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_TILE_MEMORY_BIT_QCOM");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_TRANSFER_DST_BIT_KHR");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_TRANSFER_SRC_BIT_KHR");
        }
        if ((flags & TRANSIENT_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_TRANSIENT_ATTACHMENT_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_DPB) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_DECODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_DST) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_DECODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_SRC) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_DECODE_SRC_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DPB) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_ENCODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DST) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_ENCODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_EMPHASIS_MAP) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_ENCODE_EMPHASIS_MAP_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_QUANTIZATION_DELTA_MAP) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_ENCODE_QUANTIZATION_DELTA_MAP_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_SRC) != 0) {
            detectedFlagBits.add("VK_IMAGE_USAGE_2_VIDEO_ENCODE_SRC_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageUsageFlags2KHR() {}
}

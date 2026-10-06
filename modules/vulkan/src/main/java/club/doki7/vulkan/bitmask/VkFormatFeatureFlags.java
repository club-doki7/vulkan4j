package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFormatFeatureFlags.html"><code>VkFormatFeatureFlags</code></a>
public final class VkFormatFeatureFlags {
    public static final int ACCELERATION_STRUCTURE_VERTEX_BUFFER_KHR = 0x20000000;
    public static final int BLIT_DST = 0x800;
    public static final int BLIT_SRC = 0x400;
    public static final int COLOR_ATTACHMENT = 0x80;
    public static final int COLOR_ATTACHMENT_BLEND = 0x100;
    public static final int COSITED_CHROMA_SAMPLES = 0x800000;
    public static final int DEPTH_STENCIL_ATTACHMENT = 0x200;
    public static final int DISJOINT = 0x400000;
    public static final int FRAGMENT_DENSITY_MAP_EXT = 0x1000000;
    public static final int FRAGMENT_SHADING_RATE_ATTACHMENT_KHR = 0x40000000;
    public static final int MIDPOINT_CHROMA_SAMPLES = 0x20000;
    public static final int SAMPLED_IMAGE = 0x1;
    public static final int SAMPLED_IMAGE_FILTER_CUBIC_EXT = 0x2000;
    public static final int SAMPLED_IMAGE_FILTER_LINEAR = 0x1000;
    public static final int SAMPLED_IMAGE_FILTER_MINMAX = 0x10000;
    public static final int SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT = 0x100000;
    public static final int SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE = 0x200000;
    public static final int SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER = 0x40000;
    public static final int SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER = 0x80000;
    public static final int STORAGE_IMAGE_ATOMIC = 0x4;
    public static final int STORAGE_IMAGE = 0x2;
    public static final int STORAGE_TEXEL_BUFFER_ATOMIC = 0x20;
    public static final int STORAGE_TEXEL_BUFFER = 0x10;
    public static final int TRANSFER_DST = 0x8000;
    public static final int TRANSFER_SRC = 0x4000;
    public static final int UNIFORM_TEXEL_BUFFER = 0x8;
    public static final int VERTEX_BUFFER = 0x40;
    public static final int VIDEO_DECODE_DPB_KHR = 0x4000000;
    public static final int VIDEO_DECODE_OUTPUT_KHR = 0x2000000;
    public static final int VIDEO_ENCODE_DPB_KHR = 0x10000000;
    public static final int VIDEO_ENCODE_INPUT_KHR = 0x8000000;

    public static String explain(@Bitmask(VkFormatFeatureFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_VERTEX_BUFFER_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_ACCELERATION_STRUCTURE_VERTEX_BUFFER_BIT_KHR");
        }
        if ((flags & BLIT_DST) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_BLIT_DST_BIT");
        }
        if ((flags & BLIT_SRC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_BLIT_SRC_BIT");
        }
        if ((flags & COLOR_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BIT");
        }
        if ((flags & COLOR_ATTACHMENT_BLEND) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BLEND_BIT");
        }
        if ((flags & COSITED_CHROMA_SAMPLES) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_COSITED_CHROMA_SAMPLES_BIT");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT");
        }
        if ((flags & DISJOINT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_DISJOINT_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_EXT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_FRAGMENT_DENSITY_MAP_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & MIDPOINT_CHROMA_SAMPLES) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_MIDPOINT_CHROMA_SAMPLES_BIT");
        }
        if ((flags & SAMPLED_IMAGE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_BIT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_CUBIC_EXT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_CUBIC_BIT_EXT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_LINEAR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_MINMAX) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_MINMAX_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT");
        }
        if ((flags & STORAGE_IMAGE_ATOMIC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_STORAGE_IMAGE_ATOMIC_BIT");
        }
        if ((flags & STORAGE_IMAGE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_STORAGE_IMAGE_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER_ATOMIC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_ATOMIC_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_BIT");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_TRANSFER_DST_BIT");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_TRANSFER_SRC_BIT");
        }
        if ((flags & UNIFORM_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_UNIFORM_TEXEL_BUFFER_BIT");
        }
        if ((flags & VERTEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_VERTEX_BUFFER_BIT");
        }
        if ((flags & VIDEO_DECODE_DPB_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_VIDEO_DECODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_OUTPUT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_VIDEO_DECODE_OUTPUT_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DPB_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_VIDEO_ENCODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_INPUT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_VIDEO_ENCODE_INPUT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFormatFeatureFlags() {}
}

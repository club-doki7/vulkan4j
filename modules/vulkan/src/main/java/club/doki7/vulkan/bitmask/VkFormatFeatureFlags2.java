package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFormatFeatureFlags2.html"><code>VkFormatFeatureFlags2</code></a>
public final class VkFormatFeatureFlags2 {
    public static final long ACCELERATION_STRUCTURE_RADIUS_BUFFER_NV = 0x8000000000000L;
    public static final long ACCELERATION_STRUCTURE_VERTEX_BUFFER_KHR = 0x20000000L;
    public static final long BLIT_DST = 0x800L;
    public static final long BLIT_SRC = 0x400L;
    public static final long BLOCK_MATCHING_QCOM = 0x1000000000L;
    public static final long BLOCK_MATCHING_SXD_QCOM = 0x100000000000L;
    public static final long BOX_FILTER_SAMPLED_QCOM = 0x2000000000L;
    public static final long COLOR_ATTACHMENT = 0x80L;
    public static final long COLOR_ATTACHMENT_BLEND = 0x100L;
    public static final long COPY_IMAGE_INDIRECT_DST_KHR = 0x800000000000000L;
    public static final long COSITED_CHROMA_SAMPLES = 0x800000L;
    public static final long DATA_GRAPH_OPTICAL_FLOW_COST_ARM = 0x400000000000000L;
    public static final long DATA_GRAPH_OPTICAL_FLOW_IMAGE_ARM = 0x100000000000000L;
    public static final long DATA_GRAPH_OPTICAL_FLOW_VECTOR_ARM = 0x200000000000000L;
    public static final long DEPTH_COPY_ON_COMPUTE_QUEUE_KHR = 0x10000000000000L;
    public static final long DEPTH_COPY_ON_TRANSFER_QUEUE_KHR = 0x20000000000000L;
    public static final long DEPTH_STENCIL_ATTACHMENT = 0x200L;
    public static final long DISJOINT = 0x400000L;
    public static final long FRAGMENT_DENSITY_MAP_EXT = 0x1000000L;
    public static final long FRAGMENT_SHADING_RATE_ATTACHMENT_KHR = 0x40000000L;
    public static final long HOST_IMAGE_TRANSFER = 0x400000000000L;
    public static final long LINEAR_COLOR_ATTACHMENT_NV = 0x4000000000L;
    public static final long MIDPOINT_CHROMA_SAMPLES = 0x20000L;
    public static final long OPTICAL_FLOW_COST_NV = 0x40000000000L;
    public static final long OPTICAL_FLOW_IMAGE_NV = 0x10000000000L;
    public static final long OPTICAL_FLOW_VECTOR_NV = 0x20000000000L;
    public static final long SAMPLED_IMAGE = 0x1L;
    public static final long SAMPLED_IMAGE_DEPTH_COMPARISON = 0x200000000L;
    public static final long SAMPLED_IMAGE_FILTER_CUBIC = 0x2000L;
    public static final long SAMPLED_IMAGE_FILTER_LINEAR_2D_IMG = 0x200000000000L;
    public static final long SAMPLED_IMAGE_FILTER_LINEAR = 0x1000L;
    public static final long SAMPLED_IMAGE_FILTER_MINMAX = 0x10000L;
    public static final long SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT = 0x100000L;
    public static final long SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE = 0x200000L;
    public static final long SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER = 0x40000L;
    public static final long SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER = 0x80000L;
    public static final long STENCIL_COPY_ON_COMPUTE_QUEUE_KHR = 0x40000000000000L;
    public static final long STENCIL_COPY_ON_TRANSFER_QUEUE_KHR = 0x80000000000000L;
    public static final long STORAGE_IMAGE_ATOMIC = 0x4L;
    public static final long STORAGE_IMAGE = 0x2L;
    public static final long STORAGE_READ_WITHOUT_FORMAT = 0x80000000L;
    public static final long STORAGE_TEXEL_BUFFER_ATOMIC = 0x20L;
    public static final long STORAGE_TEXEL_BUFFER = 0x10L;
    public static final long STORAGE_WRITE_WITHOUT_FORMAT = 0x100000000L;
    public static final long TENSOR_DATA_GRAPH_ARM = 0x1000000000000L;
    public static final long TENSOR_IMAGE_ALIASING_ARM = 0x80000000000L;
    public static final long TENSOR_SHADER_ARM = 0x8000000000L;
    public static final long TRANSFER_DST = 0x8000L;
    public static final long TRANSFER_SRC = 0x4000L;
    public static final long UNIFORM_TEXEL_BUFFER = 0x8L;
    public static final long VERTEX_BUFFER = 0x40L;
    public static final long VIDEO_DECODE_DPB_KHR = 0x4000000L;
    public static final long VIDEO_DECODE_OUTPUT_KHR = 0x2000000L;
    public static final long VIDEO_ENCODE_DPB_KHR = 0x10000000L;
    public static final long VIDEO_ENCODE_EMPHASIS_MAP_KHR = 0x4000000000000L;
    public static final long VIDEO_ENCODE_INPUT_KHR = 0x8000000L;
    public static final long VIDEO_ENCODE_QUANTIZATION_DELTA_MAP_KHR = 0x2000000000000L;
    public static final long WEIGHT_IMAGE_QCOM = 0x400000000L;
    public static final long WEIGHT_SAMPLED_IMAGE_QCOM = 0x800000000L;

    public static String explain(@Bitmask(VkFormatFeatureFlags2.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_RADIUS_BUFFER_NV) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_ACCELERATION_STRUCTURE_RADIUS_BUFFER_BIT_NV");
        }
        if ((flags & ACCELERATION_STRUCTURE_VERTEX_BUFFER_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_ACCELERATION_STRUCTURE_VERTEX_BUFFER_BIT_KHR");
        }
        if ((flags & BLIT_DST) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_BLIT_DST_BIT");
        }
        if ((flags & BLIT_SRC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_BLIT_SRC_BIT");
        }
        if ((flags & BLOCK_MATCHING_QCOM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_BLOCK_MATCHING_BIT_QCOM");
        }
        if ((flags & BLOCK_MATCHING_SXD_QCOM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_BLOCK_MATCHING_SXD_BIT_QCOM");
        }
        if ((flags & BOX_FILTER_SAMPLED_QCOM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_BOX_FILTER_SAMPLED_BIT_QCOM");
        }
        if ((flags & COLOR_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_COLOR_ATTACHMENT_BIT");
        }
        if ((flags & COLOR_ATTACHMENT_BLEND) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_COLOR_ATTACHMENT_BLEND_BIT");
        }
        if ((flags & COPY_IMAGE_INDIRECT_DST_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_COPY_IMAGE_INDIRECT_DST_BIT_KHR");
        }
        if ((flags & COSITED_CHROMA_SAMPLES) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_COSITED_CHROMA_SAMPLES_BIT");
        }
        if ((flags & DATA_GRAPH_OPTICAL_FLOW_COST_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DATA_GRAPH_OPTICAL_FLOW_COST_BIT_ARM");
        }
        if ((flags & DATA_GRAPH_OPTICAL_FLOW_IMAGE_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DATA_GRAPH_OPTICAL_FLOW_IMAGE_BIT_ARM");
        }
        if ((flags & DATA_GRAPH_OPTICAL_FLOW_VECTOR_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DATA_GRAPH_OPTICAL_FLOW_VECTOR_BIT_ARM");
        }
        if ((flags & DEPTH_COPY_ON_COMPUTE_QUEUE_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DEPTH_COPY_ON_COMPUTE_QUEUE_BIT_KHR");
        }
        if ((flags & DEPTH_COPY_ON_TRANSFER_QUEUE_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DEPTH_COPY_ON_TRANSFER_QUEUE_BIT_KHR");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DEPTH_STENCIL_ATTACHMENT_BIT");
        }
        if ((flags & DISJOINT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_DISJOINT_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_EXT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_FRAGMENT_DENSITY_MAP_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & HOST_IMAGE_TRANSFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_HOST_IMAGE_TRANSFER_BIT");
        }
        if ((flags & LINEAR_COLOR_ATTACHMENT_NV) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_LINEAR_COLOR_ATTACHMENT_BIT_NV");
        }
        if ((flags & MIDPOINT_CHROMA_SAMPLES) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_MIDPOINT_CHROMA_SAMPLES_BIT");
        }
        if ((flags & OPTICAL_FLOW_COST_NV) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_OPTICAL_FLOW_COST_BIT_NV");
        }
        if ((flags & OPTICAL_FLOW_IMAGE_NV) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_OPTICAL_FLOW_IMAGE_BIT_NV");
        }
        if ((flags & OPTICAL_FLOW_VECTOR_NV) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_OPTICAL_FLOW_VECTOR_BIT_NV");
        }
        if ((flags & SAMPLED_IMAGE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_BIT");
        }
        if ((flags & SAMPLED_IMAGE_DEPTH_COMPARISON) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_DEPTH_COMPARISON_BIT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_CUBIC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_FILTER_CUBIC_BIT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_LINEAR_2D_IMG) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_FILTER_LINEAR_2D_BIT_IMG");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_LINEAR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_FILTER_LINEAR_BIT");
        }
        if ((flags & SAMPLED_IMAGE_FILTER_MINMAX) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_FILTER_MINMAX_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_YCBCR_CONVERSION_CHROMA_RECONSTRUCTION_EXPLICIT_FORCEABLE_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_YCBCR_CONVERSION_LINEAR_FILTER_BIT");
        }
        if ((flags & SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_SAMPLED_IMAGE_YCBCR_CONVERSION_SEPARATE_RECONSTRUCTION_FILTER_BIT");
        }
        if ((flags & STENCIL_COPY_ON_COMPUTE_QUEUE_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STENCIL_COPY_ON_COMPUTE_QUEUE_BIT_KHR");
        }
        if ((flags & STENCIL_COPY_ON_TRANSFER_QUEUE_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STENCIL_COPY_ON_TRANSFER_QUEUE_BIT_KHR");
        }
        if ((flags & STORAGE_IMAGE_ATOMIC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_IMAGE_ATOMIC_BIT");
        }
        if ((flags & STORAGE_IMAGE) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_IMAGE_BIT");
        }
        if ((flags & STORAGE_READ_WITHOUT_FORMAT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_READ_WITHOUT_FORMAT_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER_ATOMIC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_TEXEL_BUFFER_ATOMIC_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_TEXEL_BUFFER_BIT");
        }
        if ((flags & STORAGE_WRITE_WITHOUT_FORMAT) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_STORAGE_WRITE_WITHOUT_FORMAT_BIT");
        }
        if ((flags & TENSOR_DATA_GRAPH_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_TENSOR_DATA_GRAPH_BIT_ARM");
        }
        if ((flags & TENSOR_IMAGE_ALIASING_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_TENSOR_IMAGE_ALIASING_BIT_ARM");
        }
        if ((flags & TENSOR_SHADER_ARM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_TENSOR_SHADER_BIT_ARM");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_TRANSFER_DST_BIT");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_TRANSFER_SRC_BIT");
        }
        if ((flags & UNIFORM_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_UNIFORM_TEXEL_BUFFER_BIT");
        }
        if ((flags & VERTEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VERTEX_BUFFER_BIT");
        }
        if ((flags & VIDEO_DECODE_DPB_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_DECODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_OUTPUT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_DECODE_OUTPUT_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DPB_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_ENCODE_DPB_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_EMPHASIS_MAP_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_ENCODE_EMPHASIS_MAP_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_INPUT_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_ENCODE_INPUT_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_QUANTIZATION_DELTA_MAP_KHR) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_VIDEO_ENCODE_QUANTIZATION_DELTA_MAP_BIT_KHR");
        }
        if ((flags & WEIGHT_IMAGE_QCOM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_WEIGHT_IMAGE_BIT_QCOM");
        }
        if ((flags & WEIGHT_SAMPLED_IMAGE_QCOM) != 0) {
            detectedFlagBits.add("VK_FORMAT_FEATURE_2_WEIGHT_SAMPLED_IMAGE_BIT_QCOM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFormatFeatureFlags2() {}
}

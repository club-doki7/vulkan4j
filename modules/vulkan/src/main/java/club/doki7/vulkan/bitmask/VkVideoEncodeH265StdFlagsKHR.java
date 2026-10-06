package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265StdFlagsKHR.html"><code>VkVideoEncodeH265StdFlagsKHR</code></a>
public final class VkVideoEncodeH265StdFlagsKHR {
    public static final int VK_VIDEO_ENCODE_H265_STD_CONSTRAINED_INTRA_PRED_FLAG_SET = 0x4000;
    public static final int VK_VIDEO_ENCODE_H265_STD_DEBLOCKING_FILTER_OVERRIDE_ENABLED_FLAG_SET = 0x10000;
    public static final int VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENTS_ENABLED_FLAG_SET = 0x20000;
    public static final int VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENT_FLAG_SET = 0x40000;
    public static final int VK_VIDEO_ENCODE_H265_STD_DIFFERENT_SLICE_QP_DELTA = 0x100000;
    public static final int VK_VIDEO_ENCODE_H265_STD_ENTROPY_CODING_SYNC_ENABLED_FLAG_SET = 0x8000;
    public static final int VK_VIDEO_ENCODE_H265_STD_INIT_QP_MINUS26 = 0x20;
    public static final int VK_VIDEO_ENCODE_H265_STD_LOG2_PARALLEL_MERGE_LEVEL_MINUS2 = 0x100;
    public static final int VK_VIDEO_ENCODE_H265_STD_PCM_ENABLED_FLAG_SET = 0x8;
    public static final int VK_VIDEO_ENCODE_H265_STD_PPS_SLICE_CHROMA_QP_OFFSETS_PRESENT_FLAG_SET = 0x1000;
    public static final int VK_VIDEO_ENCODE_H265_STD_SAMPLE_ADAPTIVE_OFFSET_ENABLED_FLAG_SET = 0x2;
    public static final int VK_VIDEO_ENCODE_H265_STD_SCALING_LIST_DATA_PRESENT_FLAG_SET = 0x4;
    public static final int VK_VIDEO_ENCODE_H265_STD_SEPARATE_COLOR_PLANE_FLAG_SET = 0x1;
    public static final int VK_VIDEO_ENCODE_H265_STD_SIGN_DATA_HIDING_ENABLED_FLAG_SET = 0x200;
    public static final int VK_VIDEO_ENCODE_H265_STD_SLICE_QP_DELTA = 0x80000;
    public static final int VK_VIDEO_ENCODE_H265_STD_SPS_TEMPORAL_MVP_ENABLED_FLAG_SET = 0x10;
    public static final int VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_SET = 0x400;
    public static final int VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_UNSET = 0x800;
    public static final int VK_VIDEO_ENCODE_H265_STD_TRANSQUANT_BYPASS_ENABLED_FLAG_SET = 0x2000;
    public static final int VK_VIDEO_ENCODE_H265_STD_WEIGHTED_BIPRED_FLAG_SET = 0x80;
    public static final int VK_VIDEO_ENCODE_H265_STD_WEIGHTED_PRED_FLAG_SET = 0x40;

    public static String explain(@Bitmask(VkVideoEncodeH265StdFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_H265_STD_CONSTRAINED_INTRA_PRED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_CONSTRAINED_INTRA_PRED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_DEBLOCKING_FILTER_OVERRIDE_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_DEBLOCKING_FILTER_OVERRIDE_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENTS_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENTS_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENT_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_DEPENDENT_SLICE_SEGMENT_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_DIFFERENT_SLICE_QP_DELTA) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_DIFFERENT_SLICE_QP_DELTA_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_ENTROPY_CODING_SYNC_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_ENTROPY_CODING_SYNC_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_INIT_QP_MINUS26) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_INIT_QP_MINUS26_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_LOG2_PARALLEL_MERGE_LEVEL_MINUS2) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_LOG2_PARALLEL_MERGE_LEVEL_MINUS2_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_PCM_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_PCM_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_PPS_SLICE_CHROMA_QP_OFFSETS_PRESENT_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_PPS_SLICE_CHROMA_QP_OFFSETS_PRESENT_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SAMPLE_ADAPTIVE_OFFSET_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SAMPLE_ADAPTIVE_OFFSET_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SCALING_LIST_DATA_PRESENT_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SCALING_LIST_DATA_PRESENT_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SEPARATE_COLOR_PLANE_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SEPARATE_COLOR_PLANE_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SIGN_DATA_HIDING_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SIGN_DATA_HIDING_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SLICE_QP_DELTA) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SLICE_QP_DELTA_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_SPS_TEMPORAL_MVP_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_SPS_TEMPORAL_MVP_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_UNSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_TRANSFORM_SKIP_ENABLED_FLAG_UNSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_TRANSQUANT_BYPASS_ENABLED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_TRANSQUANT_BYPASS_ENABLED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_WEIGHTED_BIPRED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_WEIGHTED_BIPRED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_STD_WEIGHTED_PRED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_STD_WEIGHTED_PRED_FLAG_SET_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeH265StdFlagsKHR() {}
}

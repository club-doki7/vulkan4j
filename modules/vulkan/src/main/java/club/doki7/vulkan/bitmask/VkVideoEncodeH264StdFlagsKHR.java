package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264StdFlagsKHR.html"><code>VkVideoEncodeH264StdFlagsKHR</code></a>
public final class VkVideoEncodeH264StdFlagsKHR {
    public static final int VK_VIDEO_ENCODE_H264_STD_CHROMA_QP_INDEX_OFFSET = 0x8;
    public static final int VK_VIDEO_ENCODE_H264_STD_CONSTRAINED_INTRA_PRED_FLAG_SET = 0x4000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_DISABLED = 0x8000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_ENABLED = 0x10000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_PARTIAL = 0x20000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DIFFERENT_SLICE_QP_DELTA = 0x100000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DIRECT_8X8_INFERENCE_FLAG_UNSET = 0x2000;
    public static final int VK_VIDEO_ENCODE_H264_STD_DIRECT_SPATIAL_MV_PRED_FLAG_UNSET = 0x400;
    public static final int VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_SET = 0x1000;
    public static final int VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_UNSET = 0x800;
    public static final int VK_VIDEO_ENCODE_H264_STD_PIC_INIT_QP_MINUS26 = 0x20;
    public static final int VK_VIDEO_ENCODE_H264_STD_QPPRIME_Y_ZERO_TRANSFORM_BYPASS_FLAG_SET = 0x2;
    public static final int VK_VIDEO_ENCODE_H264_STD_SCALING_MATRIX_PRESENT_FLAG_SET = 0x4;
    public static final int VK_VIDEO_ENCODE_H264_STD_SECOND_CHROMA_QP_INDEX_OFFSET = 0x10;
    public static final int VK_VIDEO_ENCODE_H264_STD_SEPARATE_COLOR_PLANE_FLAG_SET = 0x1;
    public static final int VK_VIDEO_ENCODE_H264_STD_SLICE_QP_DELTA = 0x80000;
    public static final int VK_VIDEO_ENCODE_H264_STD_TRANSFORM_8X8_MODE_FLAG_SET = 0x200;
    public static final int VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_EXPLICIT = 0x80;
    public static final int VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_IMPLICIT = 0x100;
    public static final int VK_VIDEO_ENCODE_H264_STD_WEIGHTED_PRED_FLAG_SET = 0x40;

    public static String explain(@Bitmask(VkVideoEncodeH264StdFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_H264_STD_CHROMA_QP_INDEX_OFFSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_CHROMA_QP_INDEX_OFFSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_CONSTRAINED_INTRA_PRED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_CONSTRAINED_INTRA_PRED_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_DISABLED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_DISABLED_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_ENABLED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_ENABLED_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_PARTIAL) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DEBLOCKING_FILTER_PARTIAL_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DIFFERENT_SLICE_QP_DELTA) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DIFFERENT_SLICE_QP_DELTA_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DIRECT_8X8_INFERENCE_FLAG_UNSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DIRECT_8X8_INFERENCE_FLAG_UNSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_DIRECT_SPATIAL_MV_PRED_FLAG_UNSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_DIRECT_SPATIAL_MV_PRED_FLAG_UNSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_UNSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_ENTROPY_CODING_MODE_FLAG_UNSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_PIC_INIT_QP_MINUS26) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_PIC_INIT_QP_MINUS26_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_QPPRIME_Y_ZERO_TRANSFORM_BYPASS_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_QPPRIME_Y_ZERO_TRANSFORM_BYPASS_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_SCALING_MATRIX_PRESENT_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_SCALING_MATRIX_PRESENT_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_SECOND_CHROMA_QP_INDEX_OFFSET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_SECOND_CHROMA_QP_INDEX_OFFSET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_SEPARATE_COLOR_PLANE_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_SEPARATE_COLOR_PLANE_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_SLICE_QP_DELTA) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_SLICE_QP_DELTA_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_TRANSFORM_8X8_MODE_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_TRANSFORM_8X8_MODE_FLAG_SET_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_EXPLICIT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_EXPLICIT_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_IMPLICIT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_WEIGHTED_BIPRED_IDC_IMPLICIT_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H264_STD_WEIGHTED_PRED_FLAG_SET) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H264_STD_WEIGHTED_PRED_FLAG_SET_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeH264StdFlagsKHR() {}
}

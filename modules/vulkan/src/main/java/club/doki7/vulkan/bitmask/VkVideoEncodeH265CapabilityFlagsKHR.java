package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265CapabilityFlagsKHR.html"><code>VkVideoEncodeH265CapabilityFlagsKHR</code></a>
public final class VkVideoEncodeH265CapabilityFlagsKHR {
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L0_LIST = 0x10;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L1_LIST = 0x20;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_B_PICTURE_INTRA_REFRESH = 0x800;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_CU_QP_DIFF_WRAPAROUND = 0x400;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_DIFFERENT_SLICE_SEGMENT_TYPE = 0x8;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_HRD_COMPLIANCE = 0x1;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_SLICE_SEGMENTS_PER_TILE = 0x200;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_TILES_PER_SLICE_SEGMENT = 0x100;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_PER_PICTURE_TYPE_MIN_MAX_QP = 0x40;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_PER_SLICE_SEGMENT_CONSTANT_QP = 0x80;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_PREDICTION_WEIGHT_TABLE_GENERATED = 0x2;
    public static final int VK_VIDEO_ENCODE_H265_CAPABILITY_ROW_UNALIGNED_SLICE_SEGMENT = 0x4;

    public static String explain(@Bitmask(VkVideoEncodeH265CapabilityFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L0_LIST) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L0_LIST_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L1_LIST) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_B_FRAME_IN_L1_LIST_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_B_PICTURE_INTRA_REFRESH) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_B_PICTURE_INTRA_REFRESH_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_CU_QP_DIFF_WRAPAROUND) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_CU_QP_DIFF_WRAPAROUND_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_DIFFERENT_SLICE_SEGMENT_TYPE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_DIFFERENT_SLICE_SEGMENT_TYPE_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_HRD_COMPLIANCE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_HRD_COMPLIANCE_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_SLICE_SEGMENTS_PER_TILE) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_SLICE_SEGMENTS_PER_TILE_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_TILES_PER_SLICE_SEGMENT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_MULTIPLE_TILES_PER_SLICE_SEGMENT_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_PER_PICTURE_TYPE_MIN_MAX_QP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_PER_PICTURE_TYPE_MIN_MAX_QP_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_PER_SLICE_SEGMENT_CONSTANT_QP) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_PER_SLICE_SEGMENT_CONSTANT_QP_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_PREDICTION_WEIGHT_TABLE_GENERATED) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_PREDICTION_WEIGHT_TABLE_GENERATED_BIT_KHR");
        }
        if ((flags & VK_VIDEO_ENCODE_H265_CAPABILITY_ROW_UNALIGNED_SLICE_SEGMENT) != 0) {
            detectedFlagBits.add("VK_VIDEO_ENCODE_H265_CAPABILITY_ROW_UNALIGNED_SLICE_SEGMENT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeH265CapabilityFlagsKHR() {}
}

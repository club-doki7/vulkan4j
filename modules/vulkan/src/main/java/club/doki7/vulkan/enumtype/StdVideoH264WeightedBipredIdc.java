package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264WeightedBipredIdc {
    public static final int STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_DEFAULT = 0x0;
    public static final int STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_EXPLICIT = 0x1;
    public static final int STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_IMPLICIT = 0x2;
    public static final int STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264WeightedBipredIdc.class) int value) {
        return switch (value) {
            case StdVideoH264WeightedBipredIdc.STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_DEFAULT -> "STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_DEFAULT";
            case StdVideoH264WeightedBipredIdc.STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_EXPLICIT -> "STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_EXPLICIT";
            case StdVideoH264WeightedBipredIdc.STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_IMPLICIT -> "STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_IMPLICIT";
            case StdVideoH264WeightedBipredIdc.STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_INVALID -> "STD_VIDEO_H264_WEIGHTED_BIPRED_IDC_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264WeightedBipredIdc() {}
}

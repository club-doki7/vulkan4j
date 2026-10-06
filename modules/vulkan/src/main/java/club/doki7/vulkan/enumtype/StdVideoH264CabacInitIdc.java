package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264CabacInitIdc {
    public static final int STD_VIDEO_H264_CABAC_INIT_IDC_0 = 0x0;
    public static final int STD_VIDEO_H264_CABAC_INIT_IDC_1 = 0x1;
    public static final int STD_VIDEO_H264_CABAC_INIT_IDC_2 = 0x2;
    public static final int STD_VIDEO_H264_CABAC_INIT_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264CabacInitIdc.class) int value) {
        return switch (value) {
            case StdVideoH264CabacInitIdc.STD_VIDEO_H264_CABAC_INIT_IDC_0 -> "STD_VIDEO_H264_CABAC_INIT_IDC_0";
            case StdVideoH264CabacInitIdc.STD_VIDEO_H264_CABAC_INIT_IDC_1 -> "STD_VIDEO_H264_CABAC_INIT_IDC_1";
            case StdVideoH264CabacInitIdc.STD_VIDEO_H264_CABAC_INIT_IDC_2 -> "STD_VIDEO_H264_CABAC_INIT_IDC_2";
            case StdVideoH264CabacInitIdc.STD_VIDEO_H264_CABAC_INIT_IDC_INVALID -> "STD_VIDEO_H264_CABAC_INIT_IDC_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264CabacInitIdc() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264LevelIdc {
    public static final int STD_VIDEO_H264_LEVEL_IDC_1_0 = 0x0;
    public static final int STD_VIDEO_H264_LEVEL_IDC_1_1 = 0x1;
    public static final int STD_VIDEO_H264_LEVEL_IDC_1_2 = 0x2;
    public static final int STD_VIDEO_H264_LEVEL_IDC_1_3 = 0x3;
    public static final int STD_VIDEO_H264_LEVEL_IDC_2_0 = 0x4;
    public static final int STD_VIDEO_H264_LEVEL_IDC_2_1 = 0x5;
    public static final int STD_VIDEO_H264_LEVEL_IDC_2_2 = 0x6;
    public static final int STD_VIDEO_H264_LEVEL_IDC_3_0 = 0x7;
    public static final int STD_VIDEO_H264_LEVEL_IDC_3_1 = 0x8;
    public static final int STD_VIDEO_H264_LEVEL_IDC_3_2 = 0x9;
    public static final int STD_VIDEO_H264_LEVEL_IDC_4_0 = 0xa;
    public static final int STD_VIDEO_H264_LEVEL_IDC_4_1 = 0xb;
    public static final int STD_VIDEO_H264_LEVEL_IDC_4_2 = 0xc;
    public static final int STD_VIDEO_H264_LEVEL_IDC_5_0 = 0xd;
    public static final int STD_VIDEO_H264_LEVEL_IDC_5_1 = 0xe;
    public static final int STD_VIDEO_H264_LEVEL_IDC_5_2 = 0xf;
    public static final int STD_VIDEO_H264_LEVEL_IDC_6_0 = 0x10;
    public static final int STD_VIDEO_H264_LEVEL_IDC_6_1 = 0x11;
    public static final int STD_VIDEO_H264_LEVEL_IDC_6_2 = 0x12;
    public static final int STD_VIDEO_H264_LEVEL_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264LevelIdc.class) int value) {
        return switch (value) {
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_1_0 -> "STD_VIDEO_H264_LEVEL_IDC_1_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_1_1 -> "STD_VIDEO_H264_LEVEL_IDC_1_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_1_2 -> "STD_VIDEO_H264_LEVEL_IDC_1_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_1_3 -> "STD_VIDEO_H264_LEVEL_IDC_1_3";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_2_0 -> "STD_VIDEO_H264_LEVEL_IDC_2_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_2_1 -> "STD_VIDEO_H264_LEVEL_IDC_2_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_2_2 -> "STD_VIDEO_H264_LEVEL_IDC_2_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_3_0 -> "STD_VIDEO_H264_LEVEL_IDC_3_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_3_1 -> "STD_VIDEO_H264_LEVEL_IDC_3_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_3_2 -> "STD_VIDEO_H264_LEVEL_IDC_3_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_4_0 -> "STD_VIDEO_H264_LEVEL_IDC_4_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_4_1 -> "STD_VIDEO_H264_LEVEL_IDC_4_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_4_2 -> "STD_VIDEO_H264_LEVEL_IDC_4_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_5_0 -> "STD_VIDEO_H264_LEVEL_IDC_5_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_5_1 -> "STD_VIDEO_H264_LEVEL_IDC_5_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_5_2 -> "STD_VIDEO_H264_LEVEL_IDC_5_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_6_0 -> "STD_VIDEO_H264_LEVEL_IDC_6_0";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_6_1 -> "STD_VIDEO_H264_LEVEL_IDC_6_1";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_6_2 -> "STD_VIDEO_H264_LEVEL_IDC_6_2";
            case StdVideoH264LevelIdc.STD_VIDEO_H264_LEVEL_IDC_INVALID -> "STD_VIDEO_H264_LEVEL_IDC_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264LevelIdc() {}
}

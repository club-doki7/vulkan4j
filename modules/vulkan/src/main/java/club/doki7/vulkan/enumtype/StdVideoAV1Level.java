package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1Level {
    public static final int STD_VIDEO_AV1_LEVEL_2_0 = 0x0;
    public static final int STD_VIDEO_AV1_LEVEL_2_1 = 0x1;
    public static final int STD_VIDEO_AV1_LEVEL_2_2 = 0x2;
    public static final int STD_VIDEO_AV1_LEVEL_2_3 = 0x3;
    public static final int STD_VIDEO_AV1_LEVEL_3_0 = 0x4;
    public static final int STD_VIDEO_AV1_LEVEL_3_1 = 0x5;
    public static final int STD_VIDEO_AV1_LEVEL_3_2 = 0x6;
    public static final int STD_VIDEO_AV1_LEVEL_3_3 = 0x7;
    public static final int STD_VIDEO_AV1_LEVEL_4_0 = 0x8;
    public static final int STD_VIDEO_AV1_LEVEL_4_1 = 0x9;
    public static final int STD_VIDEO_AV1_LEVEL_4_2 = 0xa;
    public static final int STD_VIDEO_AV1_LEVEL_4_3 = 0xb;
    public static final int STD_VIDEO_AV1_LEVEL_5_0 = 0xc;
    public static final int STD_VIDEO_AV1_LEVEL_5_1 = 0xd;
    public static final int STD_VIDEO_AV1_LEVEL_5_2 = 0xe;
    public static final int STD_VIDEO_AV1_LEVEL_5_3 = 0xf;
    public static final int STD_VIDEO_AV1_LEVEL_6_0 = 0x10;
    public static final int STD_VIDEO_AV1_LEVEL_6_1 = 0x11;
    public static final int STD_VIDEO_AV1_LEVEL_6_2 = 0x12;
    public static final int STD_VIDEO_AV1_LEVEL_6_3 = 0x13;
    public static final int STD_VIDEO_AV1_LEVEL_7_0 = 0x14;
    public static final int STD_VIDEO_AV1_LEVEL_7_1 = 0x15;
    public static final int STD_VIDEO_AV1_LEVEL_7_2 = 0x16;
    public static final int STD_VIDEO_AV1_LEVEL_7_3 = 0x17;
    public static final int STD_VIDEO_AV1_LEVEL_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1Level.class) int value) {
        return switch (value) {
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_2_0 -> "STD_VIDEO_AV1_LEVEL_2_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_2_1 -> "STD_VIDEO_AV1_LEVEL_2_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_2_2 -> "STD_VIDEO_AV1_LEVEL_2_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_2_3 -> "STD_VIDEO_AV1_LEVEL_2_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_3_0 -> "STD_VIDEO_AV1_LEVEL_3_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_3_1 -> "STD_VIDEO_AV1_LEVEL_3_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_3_2 -> "STD_VIDEO_AV1_LEVEL_3_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_3_3 -> "STD_VIDEO_AV1_LEVEL_3_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_4_0 -> "STD_VIDEO_AV1_LEVEL_4_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_4_1 -> "STD_VIDEO_AV1_LEVEL_4_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_4_2 -> "STD_VIDEO_AV1_LEVEL_4_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_4_3 -> "STD_VIDEO_AV1_LEVEL_4_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_5_0 -> "STD_VIDEO_AV1_LEVEL_5_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_5_1 -> "STD_VIDEO_AV1_LEVEL_5_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_5_2 -> "STD_VIDEO_AV1_LEVEL_5_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_5_3 -> "STD_VIDEO_AV1_LEVEL_5_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_6_0 -> "STD_VIDEO_AV1_LEVEL_6_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_6_1 -> "STD_VIDEO_AV1_LEVEL_6_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_6_2 -> "STD_VIDEO_AV1_LEVEL_6_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_6_3 -> "STD_VIDEO_AV1_LEVEL_6_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_7_0 -> "STD_VIDEO_AV1_LEVEL_7_0";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_7_1 -> "STD_VIDEO_AV1_LEVEL_7_1";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_7_2 -> "STD_VIDEO_AV1_LEVEL_7_2";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_7_3 -> "STD_VIDEO_AV1_LEVEL_7_3";
            case StdVideoAV1Level.STD_VIDEO_AV1_LEVEL_INVALID -> "STD_VIDEO_AV1_LEVEL_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1Level() {}
}

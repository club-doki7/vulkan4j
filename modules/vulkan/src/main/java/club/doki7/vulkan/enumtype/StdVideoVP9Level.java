package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9Level {
    public static final int STD_VIDEO_VP9_LEVEL_1_0 = 0x0;
    public static final int STD_VIDEO_VP9_LEVEL_1_1 = 0x1;
    public static final int STD_VIDEO_VP9_LEVEL_2_0 = 0x2;
    public static final int STD_VIDEO_VP9_LEVEL_2_1 = 0x3;
    public static final int STD_VIDEO_VP9_LEVEL_3_0 = 0x4;
    public static final int STD_VIDEO_VP9_LEVEL_3_1 = 0x5;
    public static final int STD_VIDEO_VP9_LEVEL_4_0 = 0x6;
    public static final int STD_VIDEO_VP9_LEVEL_4_1 = 0x7;
    public static final int STD_VIDEO_VP9_LEVEL_5_0 = 0x8;
    public static final int STD_VIDEO_VP9_LEVEL_5_1 = 0x9;
    public static final int STD_VIDEO_VP9_LEVEL_5_2 = 0xa;
    public static final int STD_VIDEO_VP9_LEVEL_6_0 = 0xb;
    public static final int STD_VIDEO_VP9_LEVEL_6_1 = 0xc;
    public static final int STD_VIDEO_VP9_LEVEL_6_2 = 0xd;
    public static final int STD_VIDEO_VP9_LEVEL_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9Level.class) int value) {
        return switch (value) {
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_1_0 -> "STD_VIDEO_VP9_LEVEL_1_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_1_1 -> "STD_VIDEO_VP9_LEVEL_1_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_2_0 -> "STD_VIDEO_VP9_LEVEL_2_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_2_1 -> "STD_VIDEO_VP9_LEVEL_2_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_3_0 -> "STD_VIDEO_VP9_LEVEL_3_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_3_1 -> "STD_VIDEO_VP9_LEVEL_3_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_4_0 -> "STD_VIDEO_VP9_LEVEL_4_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_4_1 -> "STD_VIDEO_VP9_LEVEL_4_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_5_0 -> "STD_VIDEO_VP9_LEVEL_5_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_5_1 -> "STD_VIDEO_VP9_LEVEL_5_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_5_2 -> "STD_VIDEO_VP9_LEVEL_5_2";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_6_0 -> "STD_VIDEO_VP9_LEVEL_6_0";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_6_1 -> "STD_VIDEO_VP9_LEVEL_6_1";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_6_2 -> "STD_VIDEO_VP9_LEVEL_6_2";
            case StdVideoVP9Level.STD_VIDEO_VP9_LEVEL_INVALID -> "STD_VIDEO_VP9_LEVEL_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9Level() {}
}

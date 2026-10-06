package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1ColorPrimaries {
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_BT_709 = 0x1;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_UNSPECIFIED = 0x2;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_M = 0x4;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_B_G = 0x5;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_BT_601 = 0x6;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_240 = 0x7;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_GENERIC_FILM = 0x8;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_BT_2020 = 0x9;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_XYZ = 0xa;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_431 = 0xb;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_432 = 0xc;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_EBU_3213 = 0x16;
    public static final int STD_VIDEO_AV1_COLOR_PRIMARIES_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1ColorPrimaries.class) int value) {
        return switch (value) {
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_BT_2020 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_BT_2020";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_B_G -> "STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_B_G";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_M -> "STD_VIDEO_AV1_COLOR_PRIMARIES_BT_470_M";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_BT_601 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_BT_601";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_BT_709 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_BT_709";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_EBU_3213 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_EBU_3213";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_GENERIC_FILM -> "STD_VIDEO_AV1_COLOR_PRIMARIES_GENERIC_FILM";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_INVALID -> "STD_VIDEO_AV1_COLOR_PRIMARIES_INVALID";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_240 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_240";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_431 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_431";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_432 -> "STD_VIDEO_AV1_COLOR_PRIMARIES_SMPTE_432";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_UNSPECIFIED -> "STD_VIDEO_AV1_COLOR_PRIMARIES_UNSPECIFIED";
            case StdVideoAV1ColorPrimaries.STD_VIDEO_AV1_COLOR_PRIMARIES_XYZ -> "STD_VIDEO_AV1_COLOR_PRIMARIES_XYZ";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1ColorPrimaries() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9ColorSpace {
    public static final int STD_VIDEO_VP9_COLOR_SPACE_UNKNOWN = 0x0;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_BT_601 = 0x1;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_BT_709 = 0x2;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_SMPTE_170 = 0x3;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_SMPTE_240 = 0x4;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_BT_2020 = 0x5;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_RESERVED = 0x6;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_RGB = 0x7;
    public static final int STD_VIDEO_VP9_COLOR_SPACE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9ColorSpace.class) int value) {
        return switch (value) {
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_BT_2020 -> "STD_VIDEO_VP9_COLOR_SPACE_BT_2020";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_BT_601 -> "STD_VIDEO_VP9_COLOR_SPACE_BT_601";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_BT_709 -> "STD_VIDEO_VP9_COLOR_SPACE_BT_709";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_INVALID -> "STD_VIDEO_VP9_COLOR_SPACE_INVALID";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_RESERVED -> "STD_VIDEO_VP9_COLOR_SPACE_RESERVED";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_RGB -> "STD_VIDEO_VP9_COLOR_SPACE_RGB";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_SMPTE_170 -> "STD_VIDEO_VP9_COLOR_SPACE_SMPTE_170";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_SMPTE_240 -> "STD_VIDEO_VP9_COLOR_SPACE_SMPTE_240";
            case StdVideoVP9ColorSpace.STD_VIDEO_VP9_COLOR_SPACE_UNKNOWN -> "STD_VIDEO_VP9_COLOR_SPACE_UNKNOWN";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9ColorSpace() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH265AspectRatioIdc {
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_UNSPECIFIED = 0x0;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_SQUARE = 0x1;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_12_11 = 0x2;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_10_11 = 0x3;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_16_11 = 0x4;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_40_33 = 0x5;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_24_11 = 0x6;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_20_11 = 0x7;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_32_11 = 0x8;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_80_33 = 0x9;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_18_11 = 0xa;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_15_11 = 0xb;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_64_33 = 0xc;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_160_99 = 0xd;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_4_3 = 0xe;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_3_2 = 0xf;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_2_1 = 0x10;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_EXTENDED_SAR = 0xff;
    public static final int STD_VIDEO_H265_ASPECT_RATIO_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH265AspectRatioIdc.class) int value) {
        return switch (value) {
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_10_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_10_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_12_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_12_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_15_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_15_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_160_99 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_160_99";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_16_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_16_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_18_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_18_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_20_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_20_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_24_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_24_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_2_1 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_2_1";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_32_11 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_32_11";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_3_2 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_3_2";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_40_33 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_40_33";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_4_3 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_4_3";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_64_33 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_64_33";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_80_33 -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_80_33";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_EXTENDED_SAR -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_EXTENDED_SAR";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_INVALID -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_INVALID";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_SQUARE -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_SQUARE";
            case StdVideoH265AspectRatioIdc.STD_VIDEO_H265_ASPECT_RATIO_IDC_UNSPECIFIED -> "STD_VIDEO_H265_ASPECT_RATIO_IDC_UNSPECIFIED";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH265AspectRatioIdc() {}
}

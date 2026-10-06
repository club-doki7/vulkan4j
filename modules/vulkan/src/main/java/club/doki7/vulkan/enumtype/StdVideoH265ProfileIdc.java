package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH265ProfileIdc {
    public static final int STD_VIDEO_H265_PROFILE_IDC_MAIN = 0x1;
    public static final int STD_VIDEO_H265_PROFILE_IDC_MAIN_10 = 0x2;
    public static final int STD_VIDEO_H265_PROFILE_IDC_MAIN_STILL_PICTURE = 0x3;
    public static final int STD_VIDEO_H265_PROFILE_IDC_FORMAT_RANGE_EXTENSIONS = 0x4;
    public static final int STD_VIDEO_H265_PROFILE_IDC_SCC_EXTENSIONS = 0x9;
    public static final int STD_VIDEO_H265_PROFILE_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH265ProfileIdc.class) int value) {
        return switch (value) {
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_FORMAT_RANGE_EXTENSIONS -> "STD_VIDEO_H265_PROFILE_IDC_FORMAT_RANGE_EXTENSIONS";
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_INVALID -> "STD_VIDEO_H265_PROFILE_IDC_INVALID";
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_MAIN -> "STD_VIDEO_H265_PROFILE_IDC_MAIN";
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_MAIN_10 -> "STD_VIDEO_H265_PROFILE_IDC_MAIN_10";
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_MAIN_STILL_PICTURE -> "STD_VIDEO_H265_PROFILE_IDC_MAIN_STILL_PICTURE";
            case StdVideoH265ProfileIdc.STD_VIDEO_H265_PROFILE_IDC_SCC_EXTENSIONS -> "STD_VIDEO_H265_PROFILE_IDC_SCC_EXTENSIONS";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH265ProfileIdc() {}
}

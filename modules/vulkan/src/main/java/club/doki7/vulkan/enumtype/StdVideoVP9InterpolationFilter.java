package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9InterpolationFilter {
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP = 0x0;
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH = 0x1;
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SHARP = 0x2;
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_BILINEAR = 0x3;
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_SWITCHABLE = 0x4;
    public static final int STD_VIDEO_VP9_INTERPOLATION_FILTER_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9InterpolationFilter.class) int value) {
        return switch (value) {
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_BILINEAR -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_BILINEAR";
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP";
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SHARP -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SHARP";
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH";
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_INVALID -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_INVALID";
            case StdVideoVP9InterpolationFilter.STD_VIDEO_VP9_INTERPOLATION_FILTER_SWITCHABLE -> "STD_VIDEO_VP9_INTERPOLATION_FILTER_SWITCHABLE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9InterpolationFilter() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1InterpolationFilter {
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP = 0x0;
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH = 0x1;
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SHARP = 0x2;
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_BILINEAR = 0x3;
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_SWITCHABLE = 0x4;
    public static final int STD_VIDEO_AV1_INTERPOLATION_FILTER_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1InterpolationFilter.class) int value) {
        return switch (value) {
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_BILINEAR -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_BILINEAR";
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP";
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SHARP -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SHARP";
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_EIGHTTAP_SMOOTH";
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_INVALID -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_INVALID";
            case StdVideoAV1InterpolationFilter.STD_VIDEO_AV1_INTERPOLATION_FILTER_SWITCHABLE -> "STD_VIDEO_AV1_INTERPOLATION_FILTER_SWITCHABLE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1InterpolationFilter() {}
}

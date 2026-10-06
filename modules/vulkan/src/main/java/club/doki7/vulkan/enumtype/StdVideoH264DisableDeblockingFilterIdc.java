package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264DisableDeblockingFilterIdc {
    public static final int STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_DISABLED = 0x0;
    public static final int STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_ENABLED = 0x1;
    public static final int STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_PARTIAL = 0x2;
    public static final int STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264DisableDeblockingFilterIdc.class) int value) {
        return switch (value) {
            case StdVideoH264DisableDeblockingFilterIdc.STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_DISABLED -> "STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_DISABLED";
            case StdVideoH264DisableDeblockingFilterIdc.STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_ENABLED -> "STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_ENABLED";
            case StdVideoH264DisableDeblockingFilterIdc.STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_INVALID -> "STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_INVALID";
            case StdVideoH264DisableDeblockingFilterIdc.STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_PARTIAL -> "STD_VIDEO_H264_DISABLE_DEBLOCKING_FILTER_IDC_PARTIAL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264DisableDeblockingFilterIdc() {}
}

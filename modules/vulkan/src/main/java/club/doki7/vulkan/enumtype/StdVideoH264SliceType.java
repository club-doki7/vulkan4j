package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264SliceType {
    public static final int STD_VIDEO_H264_SLICE_TYPE_P = 0x0;
    public static final int STD_VIDEO_H264_SLICE_TYPE_B = 0x1;
    public static final int STD_VIDEO_H264_SLICE_TYPE_I = 0x2;
    public static final int STD_VIDEO_H264_SLICE_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264SliceType.class) int value) {
        return switch (value) {
            case StdVideoH264SliceType.STD_VIDEO_H264_SLICE_TYPE_B -> "STD_VIDEO_H264_SLICE_TYPE_B";
            case StdVideoH264SliceType.STD_VIDEO_H264_SLICE_TYPE_I -> "STD_VIDEO_H264_SLICE_TYPE_I";
            case StdVideoH264SliceType.STD_VIDEO_H264_SLICE_TYPE_INVALID -> "STD_VIDEO_H264_SLICE_TYPE_INVALID";
            case StdVideoH264SliceType.STD_VIDEO_H264_SLICE_TYPE_P -> "STD_VIDEO_H264_SLICE_TYPE_P";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264SliceType() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264PocType {
    public static final int STD_VIDEO_H264_POC_TYPE_0 = 0x0;
    public static final int STD_VIDEO_H264_POC_TYPE_1 = 0x1;
    public static final int STD_VIDEO_H264_POC_TYPE_2 = 0x2;
    public static final int STD_VIDEO_H264_POC_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264PocType.class) int value) {
        return switch (value) {
            case StdVideoH264PocType.STD_VIDEO_H264_POC_TYPE_0 -> "STD_VIDEO_H264_POC_TYPE_0";
            case StdVideoH264PocType.STD_VIDEO_H264_POC_TYPE_1 -> "STD_VIDEO_H264_POC_TYPE_1";
            case StdVideoH264PocType.STD_VIDEO_H264_POC_TYPE_2 -> "STD_VIDEO_H264_POC_TYPE_2";
            case StdVideoH264PocType.STD_VIDEO_H264_POC_TYPE_INVALID -> "STD_VIDEO_H264_POC_TYPE_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264PocType() {}
}

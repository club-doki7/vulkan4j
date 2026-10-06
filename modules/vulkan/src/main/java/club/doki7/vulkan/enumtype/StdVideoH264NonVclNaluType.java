package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264NonVclNaluType {
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_SPS = 0x0;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_PPS = 0x1;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_AUD = 0x2;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_PREFIX = 0x3;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_SEQUENCE = 0x4;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_STREAM = 0x5;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_PRECODED = 0x6;
    public static final int STD_VIDEO_H264_NON_VCL_NALU_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264NonVclNaluType.class) int value) {
        return switch (value) {
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_AUD -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_AUD";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_SEQUENCE -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_SEQUENCE";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_STREAM -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_END_OF_STREAM";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_INVALID -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_INVALID";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_PPS -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_PPS";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_PRECODED -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_PRECODED";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_PREFIX -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_PREFIX";
            case StdVideoH264NonVclNaluType.STD_VIDEO_H264_NON_VCL_NALU_TYPE_SPS -> "STD_VIDEO_H264_NON_VCL_NALU_TYPE_SPS";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264NonVclNaluType() {}
}

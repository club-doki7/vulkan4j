package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264ChromaFormatIdc {
    public static final int STD_VIDEO_H264_CHROMA_FORMAT_IDC_MONOCHROME = 0x0;
    public static final int STD_VIDEO_H264_CHROMA_FORMAT_IDC_420 = 0x1;
    public static final int STD_VIDEO_H264_CHROMA_FORMAT_IDC_422 = 0x2;
    public static final int STD_VIDEO_H264_CHROMA_FORMAT_IDC_444 = 0x3;
    public static final int STD_VIDEO_H264_CHROMA_FORMAT_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264ChromaFormatIdc.class) int value) {
        return switch (value) {
            case StdVideoH264ChromaFormatIdc.STD_VIDEO_H264_CHROMA_FORMAT_IDC_420 -> "STD_VIDEO_H264_CHROMA_FORMAT_IDC_420";
            case StdVideoH264ChromaFormatIdc.STD_VIDEO_H264_CHROMA_FORMAT_IDC_422 -> "STD_VIDEO_H264_CHROMA_FORMAT_IDC_422";
            case StdVideoH264ChromaFormatIdc.STD_VIDEO_H264_CHROMA_FORMAT_IDC_444 -> "STD_VIDEO_H264_CHROMA_FORMAT_IDC_444";
            case StdVideoH264ChromaFormatIdc.STD_VIDEO_H264_CHROMA_FORMAT_IDC_INVALID -> "STD_VIDEO_H264_CHROMA_FORMAT_IDC_INVALID";
            case StdVideoH264ChromaFormatIdc.STD_VIDEO_H264_CHROMA_FORMAT_IDC_MONOCHROME -> "STD_VIDEO_H264_CHROMA_FORMAT_IDC_MONOCHROME";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264ChromaFormatIdc() {}
}

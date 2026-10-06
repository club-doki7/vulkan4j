package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH264ModificationOfPicNumsIdc {
    public static final int STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_SUBTRACT = 0x0;
    public static final int STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_ADD = 0x1;
    public static final int STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_LONG_TERM = 0x2;
    public static final int STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_END = 0x3;
    public static final int STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH264ModificationOfPicNumsIdc.class) int value) {
        return switch (value) {
            case StdVideoH264ModificationOfPicNumsIdc.STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_END -> "STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_END";
            case StdVideoH264ModificationOfPicNumsIdc.STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_INVALID -> "STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_INVALID";
            case StdVideoH264ModificationOfPicNumsIdc.STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_LONG_TERM -> "STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_LONG_TERM";
            case StdVideoH264ModificationOfPicNumsIdc.STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_ADD -> "STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_ADD";
            case StdVideoH264ModificationOfPicNumsIdc.STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_SUBTRACT -> "STD_VIDEO_H264_MODIFICATION_OF_PIC_NUMS_IDC_SHORT_TERM_SUBTRACT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH264ModificationOfPicNumsIdc() {}
}

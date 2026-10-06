package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoDecodeH264FieldOrderCount {
    public static final int STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_TOP = 0x0;
    public static final int STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_BOTTOM = 0x1;
    public static final int STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoDecodeH264FieldOrderCount.class) int value) {
        return switch (value) {
            case StdVideoDecodeH264FieldOrderCount.STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_BOTTOM -> "STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_BOTTOM";
            case StdVideoDecodeH264FieldOrderCount.STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_INVALID -> "STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_INVALID";
            case StdVideoDecodeH264FieldOrderCount.STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_TOP -> "STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_TOP";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoDecodeH264FieldOrderCount() {}
}

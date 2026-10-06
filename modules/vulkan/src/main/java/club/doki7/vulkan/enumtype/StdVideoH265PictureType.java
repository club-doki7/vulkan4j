package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoH265PictureType {
    public static final int STD_VIDEO_H265_PICTURE_TYPE_P = 0x0;
    public static final int STD_VIDEO_H265_PICTURE_TYPE_B = 0x1;
    public static final int STD_VIDEO_H265_PICTURE_TYPE_I = 0x2;
    public static final int STD_VIDEO_H265_PICTURE_TYPE_IDR = 0x3;
    public static final int STD_VIDEO_H265_PICTURE_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoH265PictureType.class) int value) {
        return switch (value) {
            case StdVideoH265PictureType.STD_VIDEO_H265_PICTURE_TYPE_B -> "STD_VIDEO_H265_PICTURE_TYPE_B";
            case StdVideoH265PictureType.STD_VIDEO_H265_PICTURE_TYPE_I -> "STD_VIDEO_H265_PICTURE_TYPE_I";
            case StdVideoH265PictureType.STD_VIDEO_H265_PICTURE_TYPE_IDR -> "STD_VIDEO_H265_PICTURE_TYPE_IDR";
            case StdVideoH265PictureType.STD_VIDEO_H265_PICTURE_TYPE_INVALID -> "STD_VIDEO_H265_PICTURE_TYPE_INVALID";
            case StdVideoH265PictureType.STD_VIDEO_H265_PICTURE_TYPE_P -> "STD_VIDEO_H265_PICTURE_TYPE_P";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoH265PictureType() {}
}

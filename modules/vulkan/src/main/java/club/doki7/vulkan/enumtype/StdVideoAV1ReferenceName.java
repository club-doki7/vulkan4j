package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1ReferenceName {
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_INTRA_FRAME = 0x0;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_LAST_FRAME = 0x1;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_LAST2_FRAME = 0x2;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_LAST3_FRAME = 0x3;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_GOLDEN_FRAME = 0x4;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_BWDREF_FRAME = 0x5;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_ALTREF2_FRAME = 0x6;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_ALTREF_FRAME = 0x7;
    public static final int STD_VIDEO_AV1_REFERENCE_NAME_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1ReferenceName.class) int value) {
        return switch (value) {
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_ALTREF2_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_ALTREF2_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_ALTREF_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_ALTREF_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_BWDREF_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_BWDREF_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_GOLDEN_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_GOLDEN_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_INTRA_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_INTRA_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_INVALID -> "STD_VIDEO_AV1_REFERENCE_NAME_INVALID";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_LAST2_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_LAST2_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_LAST3_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_LAST3_FRAME";
            case StdVideoAV1ReferenceName.STD_VIDEO_AV1_REFERENCE_NAME_LAST_FRAME -> "STD_VIDEO_AV1_REFERENCE_NAME_LAST_FRAME";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1ReferenceName() {}
}

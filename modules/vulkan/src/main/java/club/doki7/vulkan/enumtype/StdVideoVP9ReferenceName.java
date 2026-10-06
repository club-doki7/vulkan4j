package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9ReferenceName {
    public static final int STD_VIDEO_VP9_REFERENCE_NAME_INTRA_FRAME = 0x0;
    public static final int STD_VIDEO_VP9_REFERENCE_NAME_LAST_FRAME = 0x1;
    public static final int STD_VIDEO_VP9_REFERENCE_NAME_GOLDEN_FRAME = 0x2;
    public static final int STD_VIDEO_VP9_REFERENCE_NAME_ALTREF_FRAME = 0x3;
    public static final int STD_VIDEO_VP9_REFERENCE_NAME_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9ReferenceName.class) int value) {
        return switch (value) {
            case StdVideoVP9ReferenceName.STD_VIDEO_VP9_REFERENCE_NAME_ALTREF_FRAME -> "STD_VIDEO_VP9_REFERENCE_NAME_ALTREF_FRAME";
            case StdVideoVP9ReferenceName.STD_VIDEO_VP9_REFERENCE_NAME_GOLDEN_FRAME -> "STD_VIDEO_VP9_REFERENCE_NAME_GOLDEN_FRAME";
            case StdVideoVP9ReferenceName.STD_VIDEO_VP9_REFERENCE_NAME_INTRA_FRAME -> "STD_VIDEO_VP9_REFERENCE_NAME_INTRA_FRAME";
            case StdVideoVP9ReferenceName.STD_VIDEO_VP9_REFERENCE_NAME_INVALID -> "STD_VIDEO_VP9_REFERENCE_NAME_INVALID";
            case StdVideoVP9ReferenceName.STD_VIDEO_VP9_REFERENCE_NAME_LAST_FRAME -> "STD_VIDEO_VP9_REFERENCE_NAME_LAST_FRAME";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9ReferenceName() {}
}

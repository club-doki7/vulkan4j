package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1FrameType {
    public static final int STD_VIDEO_AV1_FRAME_TYPE_KEY = 0x0;
    public static final int STD_VIDEO_AV1_FRAME_TYPE_INTER = 0x1;
    public static final int STD_VIDEO_AV1_FRAME_TYPE_INTRA_ONLY = 0x2;
    public static final int STD_VIDEO_AV1_FRAME_TYPE_SWITCH = 0x3;
    public static final int STD_VIDEO_AV1_FRAME_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1FrameType.class) int value) {
        return switch (value) {
            case StdVideoAV1FrameType.STD_VIDEO_AV1_FRAME_TYPE_INTER -> "STD_VIDEO_AV1_FRAME_TYPE_INTER";
            case StdVideoAV1FrameType.STD_VIDEO_AV1_FRAME_TYPE_INTRA_ONLY -> "STD_VIDEO_AV1_FRAME_TYPE_INTRA_ONLY";
            case StdVideoAV1FrameType.STD_VIDEO_AV1_FRAME_TYPE_INVALID -> "STD_VIDEO_AV1_FRAME_TYPE_INVALID";
            case StdVideoAV1FrameType.STD_VIDEO_AV1_FRAME_TYPE_KEY -> "STD_VIDEO_AV1_FRAME_TYPE_KEY";
            case StdVideoAV1FrameType.STD_VIDEO_AV1_FRAME_TYPE_SWITCH -> "STD_VIDEO_AV1_FRAME_TYPE_SWITCH";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1FrameType() {}
}

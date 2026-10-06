package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9FrameType {
    public static final int STD_VIDEO_VP9_FRAME_TYPE_KEY = 0x0;
    public static final int STD_VIDEO_VP9_FRAME_TYPE_NON_KEY = 0x1;
    public static final int STD_VIDEO_VP9_FRAME_TYPE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9FrameType.class) int value) {
        return switch (value) {
            case StdVideoVP9FrameType.STD_VIDEO_VP9_FRAME_TYPE_INVALID -> "STD_VIDEO_VP9_FRAME_TYPE_INVALID";
            case StdVideoVP9FrameType.STD_VIDEO_VP9_FRAME_TYPE_KEY -> "STD_VIDEO_VP9_FRAME_TYPE_KEY";
            case StdVideoVP9FrameType.STD_VIDEO_VP9_FRAME_TYPE_NON_KEY -> "STD_VIDEO_VP9_FRAME_TYPE_NON_KEY";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9FrameType() {}
}

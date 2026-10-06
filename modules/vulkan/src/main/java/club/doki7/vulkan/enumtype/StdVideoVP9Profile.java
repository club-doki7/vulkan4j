package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoVP9Profile {
    public static final int STD_VIDEO_VP9_PROFILE_0 = 0x0;
    public static final int STD_VIDEO_VP9_PROFILE_1 = 0x1;
    public static final int STD_VIDEO_VP9_PROFILE_2 = 0x2;
    public static final int STD_VIDEO_VP9_PROFILE_3 = 0x3;
    public static final int STD_VIDEO_VP9_PROFILE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoVP9Profile.class) int value) {
        return switch (value) {
            case StdVideoVP9Profile.STD_VIDEO_VP9_PROFILE_0 -> "STD_VIDEO_VP9_PROFILE_0";
            case StdVideoVP9Profile.STD_VIDEO_VP9_PROFILE_1 -> "STD_VIDEO_VP9_PROFILE_1";
            case StdVideoVP9Profile.STD_VIDEO_VP9_PROFILE_2 -> "STD_VIDEO_VP9_PROFILE_2";
            case StdVideoVP9Profile.STD_VIDEO_VP9_PROFILE_3 -> "STD_VIDEO_VP9_PROFILE_3";
            case StdVideoVP9Profile.STD_VIDEO_VP9_PROFILE_INVALID -> "STD_VIDEO_VP9_PROFILE_INVALID";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoVP9Profile() {}
}

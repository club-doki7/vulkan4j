package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1Profile {
    public static final int STD_VIDEO_AV1_PROFILE_MAIN = 0x0;
    public static final int STD_VIDEO_AV1_PROFILE_HIGH = 0x1;
    public static final int STD_VIDEO_AV1_PROFILE_PROFESSIONAL = 0x2;
    public static final int STD_VIDEO_AV1_PROFILE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1Profile.class) int value) {
        return switch (value) {
            case StdVideoAV1Profile.STD_VIDEO_AV1_PROFILE_HIGH -> "STD_VIDEO_AV1_PROFILE_HIGH";
            case StdVideoAV1Profile.STD_VIDEO_AV1_PROFILE_INVALID -> "STD_VIDEO_AV1_PROFILE_INVALID";
            case StdVideoAV1Profile.STD_VIDEO_AV1_PROFILE_MAIN -> "STD_VIDEO_AV1_PROFILE_MAIN";
            case StdVideoAV1Profile.STD_VIDEO_AV1_PROFILE_PROFESSIONAL -> "STD_VIDEO_AV1_PROFILE_PROFESSIONAL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1Profile() {}
}

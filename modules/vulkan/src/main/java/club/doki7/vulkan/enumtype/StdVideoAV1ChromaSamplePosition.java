package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1ChromaSamplePosition {
    public static final int STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_UNKNOWN = 0x0;
    public static final int STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_VERTICAL = 0x1;
    public static final int STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_COLOCATED = 0x2;
    public static final int STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_RESERVED = 0x3;
    public static final int STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1ChromaSamplePosition.class) int value) {
        return switch (value) {
            case StdVideoAV1ChromaSamplePosition.STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_COLOCATED -> "STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_COLOCATED";
            case StdVideoAV1ChromaSamplePosition.STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_INVALID -> "STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_INVALID";
            case StdVideoAV1ChromaSamplePosition.STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_RESERVED -> "STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_RESERVED";
            case StdVideoAV1ChromaSamplePosition.STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_UNKNOWN -> "STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_UNKNOWN";
            case StdVideoAV1ChromaSamplePosition.STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_VERTICAL -> "STD_VIDEO_AV1_CHROMA_SAMPLE_POSITION_VERTICAL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1ChromaSamplePosition() {}
}

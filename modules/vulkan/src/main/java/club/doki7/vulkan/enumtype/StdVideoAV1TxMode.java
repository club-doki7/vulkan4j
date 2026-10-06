package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

public final class StdVideoAV1TxMode {
    public static final int STD_VIDEO_AV1_TX_MODE_ONLY_4X4 = 0x0;
    public static final int STD_VIDEO_AV1_TX_MODE_LARGEST = 0x1;
    public static final int STD_VIDEO_AV1_TX_MODE_SELECT = 0x2;
    public static final int STD_VIDEO_AV1_TX_MODE_INVALID = 0x7fffffff;

    public static String explain(@EnumType(StdVideoAV1TxMode.class) int value) {
        return switch (value) {
            case StdVideoAV1TxMode.STD_VIDEO_AV1_TX_MODE_INVALID -> "STD_VIDEO_AV1_TX_MODE_INVALID";
            case StdVideoAV1TxMode.STD_VIDEO_AV1_TX_MODE_LARGEST -> "STD_VIDEO_AV1_TX_MODE_LARGEST";
            case StdVideoAV1TxMode.STD_VIDEO_AV1_TX_MODE_ONLY_4X4 -> "STD_VIDEO_AV1_TX_MODE_ONLY_4X4";
            case StdVideoAV1TxMode.STD_VIDEO_AV1_TX_MODE_SELECT -> "STD_VIDEO_AV1_TX_MODE_SELECT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private StdVideoAV1TxMode() {}
}

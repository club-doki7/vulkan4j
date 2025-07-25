package club.doki7.webgpu.enumtype;

import club.doki7.ffm.annotation.*;

public final class WGPUFeatureLevel {
    public static final int COMPATIBILITY = 0x1;
    public static final int CORE = 0x2;

    public static String explain(@EnumType(WGPUFeatureLevel.class) int value) {
        return switch (value) {
            case WGPUFeatureLevel.COMPATIBILITY -> "COMPATIBILITY";
            case WGPUFeatureLevel.CORE -> "CORE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private WGPUFeatureLevel() {}
}

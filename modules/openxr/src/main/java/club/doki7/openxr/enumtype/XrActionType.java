package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionType.html"><code>XrActionType</code></a>
public final class XrActionType {
    public static final int BOOLEAN_INPUT = 0x1;
    public static final int FLOAT_INPUT = 0x2;
    public static final int VECTOR2F_INPUT = 0x3;
    public static final int POSE_INPUT = 0x4;
    public static final int VIBRATION_OUTPUT = 0x64;

    public static String explain(@EnumType(XrActionType.class) int value) {
        return switch (value) {
            case XrActionType.BOOLEAN_INPUT -> "XR_ACTION_TYPE_BOOLEAN_INPUT";
            case XrActionType.FLOAT_INPUT -> "XR_ACTION_TYPE_FLOAT_INPUT";
            case XrActionType.POSE_INPUT -> "XR_ACTION_TYPE_POSE_INPUT";
            case XrActionType.VECTOR2F_INPUT -> "XR_ACTION_TYPE_VECTOR2F_INPUT";
            case XrActionType.VIBRATION_OUTPUT -> "XR_ACTION_TYPE_VIBRATION_OUTPUT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrActionType() {}
}

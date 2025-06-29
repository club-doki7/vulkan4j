package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrEyeExpressionHTC.html"><code>XrEyeExpressionHTC</code></a>
public final class XrEyeExpressionHTC {
    public static final int LEFT_BLINK = 0x0;
    public static final int LEFT_WIDE = 0x1;
    public static final int RIGHT_BLINK = 0x2;
    public static final int RIGHT_WIDE = 0x3;
    public static final int LEFT_SQUEEZE = 0x4;
    public static final int RIGHT_SQUEEZE = 0x5;
    public static final int LEFT_DOWN = 0x6;
    public static final int RIGHT_DOWN = 0x7;
    public static final int LEFT_OUT = 0x8;
    public static final int RIGHT_IN = 0x9;
    public static final int LEFT_IN = 0xa;
    public static final int RIGHT_OUT = 0xb;
    public static final int LEFT_UP = 0xc;
    public static final int RIGHT_UP = 0xd;

    public static String explain(@EnumType(XrEyeExpressionHTC.class) int value) {
        return switch (value) {
            case XrEyeExpressionHTC.LEFT_BLINK -> "XR_EYE_EXPRESSION_LEFT_BLINK_HTC";
            case XrEyeExpressionHTC.LEFT_DOWN -> "XR_EYE_EXPRESSION_LEFT_DOWN_HTC";
            case XrEyeExpressionHTC.LEFT_IN -> "XR_EYE_EXPRESSION_LEFT_IN_HTC";
            case XrEyeExpressionHTC.LEFT_OUT -> "XR_EYE_EXPRESSION_LEFT_OUT_HTC";
            case XrEyeExpressionHTC.LEFT_SQUEEZE -> "XR_EYE_EXPRESSION_LEFT_SQUEEZE_HTC";
            case XrEyeExpressionHTC.LEFT_UP -> "XR_EYE_EXPRESSION_LEFT_UP_HTC";
            case XrEyeExpressionHTC.LEFT_WIDE -> "XR_EYE_EXPRESSION_LEFT_WIDE_HTC";
            case XrEyeExpressionHTC.RIGHT_BLINK -> "XR_EYE_EXPRESSION_RIGHT_BLINK_HTC";
            case XrEyeExpressionHTC.RIGHT_DOWN -> "XR_EYE_EXPRESSION_RIGHT_DOWN_HTC";
            case XrEyeExpressionHTC.RIGHT_IN -> "XR_EYE_EXPRESSION_RIGHT_IN_HTC";
            case XrEyeExpressionHTC.RIGHT_OUT -> "XR_EYE_EXPRESSION_RIGHT_OUT_HTC";
            case XrEyeExpressionHTC.RIGHT_SQUEEZE -> "XR_EYE_EXPRESSION_RIGHT_SQUEEZE_HTC";
            case XrEyeExpressionHTC.RIGHT_UP -> "XR_EYE_EXPRESSION_RIGHT_UP_HTC";
            case XrEyeExpressionHTC.RIGHT_WIDE -> "XR_EYE_EXPRESSION_RIGHT_WIDE_HTC";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrEyeExpressionHTC() {}
}

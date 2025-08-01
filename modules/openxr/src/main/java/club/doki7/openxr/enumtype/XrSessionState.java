package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSessionState.html"><code>XrSessionState</code></a>
public final class XrSessionState {
    public static final int UNKNOWN = 0x0;
    public static final int IDLE = 0x1;
    public static final int READY = 0x2;
    public static final int SYNCHRONIZED = 0x3;
    public static final int VISIBLE = 0x4;
    public static final int FOCUSED = 0x5;
    public static final int STOPPING = 0x6;
    public static final int LOSS_PENDING = 0x7;
    public static final int EXITING = 0x8;

    public static String explain(@EnumType(XrSessionState.class) int value) {
        return switch (value) {
            case XrSessionState.EXITING -> "XR_SESSION_STATE_EXITING";
            case XrSessionState.FOCUSED -> "XR_SESSION_STATE_FOCUSED";
            case XrSessionState.IDLE -> "XR_SESSION_STATE_IDLE";
            case XrSessionState.LOSS_PENDING -> "XR_SESSION_STATE_LOSS_PENDING";
            case XrSessionState.READY -> "XR_SESSION_STATE_READY";
            case XrSessionState.STOPPING -> "XR_SESSION_STATE_STOPPING";
            case XrSessionState.SYNCHRONIZED -> "XR_SESSION_STATE_SYNCHRONIZED";
            case XrSessionState.UNKNOWN -> "XR_SESSION_STATE_UNKNOWN";
            case XrSessionState.VISIBLE -> "XR_SESSION_STATE_VISIBLE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrSessionState() {}
}

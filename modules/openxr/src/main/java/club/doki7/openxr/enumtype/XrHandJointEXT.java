package club.doki7.openxr.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrHandJointEXT.html"><code>XrHandJointEXT</code></a>
public final class XrHandJointEXT {
    public static final int PALM = 0x0;
    public static final int WRIST = 0x1;
    public static final int THUMB_METACARPAL = 0x2;
    public static final int THUMB_PROXIMAL = 0x3;
    public static final int THUMB_DISTAL = 0x4;
    public static final int THUMB_TIP = 0x5;
    public static final int INDEX_METACARPAL = 0x6;
    public static final int INDEX_PROXIMAL = 0x7;
    public static final int INDEX_INTERMEDIATE = 0x8;
    public static final int INDEX_DISTAL = 0x9;
    public static final int INDEX_TIP = 0xa;
    public static final int MIDDLE_METACARPAL = 0xb;
    public static final int MIDDLE_PROXIMAL = 0xc;
    public static final int MIDDLE_INTERMEDIATE = 0xd;
    public static final int MIDDLE_DISTAL = 0xe;
    public static final int MIDDLE_TIP = 0xf;
    public static final int RING_METACARPAL = 0x10;
    public static final int RING_PROXIMAL = 0x11;
    public static final int RING_INTERMEDIATE = 0x12;
    public static final int RING_DISTAL = 0x13;
    public static final int RING_TIP = 0x14;
    public static final int LITTLE_METACARPAL = 0x15;
    public static final int LITTLE_PROXIMAL = 0x16;
    public static final int LITTLE_INTERMEDIATE = 0x17;
    public static final int LITTLE_DISTAL = 0x18;
    public static final int LITTLE_TIP = 0x19;

    public static String explain(@EnumType(XrHandJointEXT.class) int value) {
        return switch (value) {
            case XrHandJointEXT.INDEX_DISTAL -> "XR_HAND_JOINT_INDEX_DISTAL_EXT";
            case XrHandJointEXT.INDEX_INTERMEDIATE -> "XR_HAND_JOINT_INDEX_INTERMEDIATE_EXT";
            case XrHandJointEXT.INDEX_METACARPAL -> "XR_HAND_JOINT_INDEX_METACARPAL_EXT";
            case XrHandJointEXT.INDEX_PROXIMAL -> "XR_HAND_JOINT_INDEX_PROXIMAL_EXT";
            case XrHandJointEXT.INDEX_TIP -> "XR_HAND_JOINT_INDEX_TIP_EXT";
            case XrHandJointEXT.LITTLE_DISTAL -> "XR_HAND_JOINT_LITTLE_DISTAL_EXT";
            case XrHandJointEXT.LITTLE_INTERMEDIATE -> "XR_HAND_JOINT_LITTLE_INTERMEDIATE_EXT";
            case XrHandJointEXT.LITTLE_METACARPAL -> "XR_HAND_JOINT_LITTLE_METACARPAL_EXT";
            case XrHandJointEXT.LITTLE_PROXIMAL -> "XR_HAND_JOINT_LITTLE_PROXIMAL_EXT";
            case XrHandJointEXT.LITTLE_TIP -> "XR_HAND_JOINT_LITTLE_TIP_EXT";
            case XrHandJointEXT.MIDDLE_DISTAL -> "XR_HAND_JOINT_MIDDLE_DISTAL_EXT";
            case XrHandJointEXT.MIDDLE_INTERMEDIATE -> "XR_HAND_JOINT_MIDDLE_INTERMEDIATE_EXT";
            case XrHandJointEXT.MIDDLE_METACARPAL -> "XR_HAND_JOINT_MIDDLE_METACARPAL_EXT";
            case XrHandJointEXT.MIDDLE_PROXIMAL -> "XR_HAND_JOINT_MIDDLE_PROXIMAL_EXT";
            case XrHandJointEXT.MIDDLE_TIP -> "XR_HAND_JOINT_MIDDLE_TIP_EXT";
            case XrHandJointEXT.PALM -> "XR_HAND_JOINT_PALM_EXT";
            case XrHandJointEXT.RING_DISTAL -> "XR_HAND_JOINT_RING_DISTAL_EXT";
            case XrHandJointEXT.RING_INTERMEDIATE -> "XR_HAND_JOINT_RING_INTERMEDIATE_EXT";
            case XrHandJointEXT.RING_METACARPAL -> "XR_HAND_JOINT_RING_METACARPAL_EXT";
            case XrHandJointEXT.RING_PROXIMAL -> "XR_HAND_JOINT_RING_PROXIMAL_EXT";
            case XrHandJointEXT.RING_TIP -> "XR_HAND_JOINT_RING_TIP_EXT";
            case XrHandJointEXT.THUMB_DISTAL -> "XR_HAND_JOINT_THUMB_DISTAL_EXT";
            case XrHandJointEXT.THUMB_METACARPAL -> "XR_HAND_JOINT_THUMB_METACARPAL_EXT";
            case XrHandJointEXT.THUMB_PROXIMAL -> "XR_HAND_JOINT_THUMB_PROXIMAL_EXT";
            case XrHandJointEXT.THUMB_TIP -> "XR_HAND_JOINT_THUMB_TIP_EXT";
            case XrHandJointEXT.WRIST -> "XR_HAND_JOINT_WRIST_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private XrHandJointEXT() {}
}

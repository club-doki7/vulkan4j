package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorSpaceKHR.html"><code>VkColorSpaceKHR</code></a>
public final class VkColorSpaceKHR {
    public static final int SRGB_NONLINEAR = 0x0;
    public static final int DISPLAY_P3_NONLINEAR_EXT = 0x3b9c6041;
    public static final int EXTENDED_SRGB_LINEAR_EXT = 0x3b9c6042;
    public static final int DISPLAY_P3_LINEAR_EXT = 0x3b9c6043;
    public static final int DCI_P3_NONLINEAR_EXT = 0x3b9c6044;
    public static final int BT709_LINEAR_EXT = 0x3b9c6045;
    public static final int BT709_NONLINEAR_EXT = 0x3b9c6046;
    public static final int BT2020_LINEAR_EXT = 0x3b9c6047;
    public static final int HDR10_ST2084_EXT = 0x3b9c6048;
    public static final int DOLBYVISION_EXT = 0x3b9c6049;
    public static final int HDR10_HLG_EXT = 0x3b9c604a;
    public static final int ADOBERGB_LINEAR_EXT = 0x3b9c604b;
    public static final int ADOBERGB_NONLINEAR_EXT = 0x3b9c604c;
    public static final int PASS_THROUGH_EXT = 0x3b9c604d;
    public static final int EXTENDED_SRGB_NONLINEAR_EXT = 0x3b9c604e;
    public static final int DISPLAY_NATIVE_AMD = 0x3b9e0a08;

    public static String explain(@EnumType(VkColorSpaceKHR.class) int value) {
        return switch (value) {
            case VkColorSpaceKHR.ADOBERGB_LINEAR_EXT -> "VK_COLOR_SPACE_ADOBERGB_LINEAR_EXT";
            case VkColorSpaceKHR.ADOBERGB_NONLINEAR_EXT -> "VK_COLOR_SPACE_ADOBERGB_NONLINEAR_EXT";
            case VkColorSpaceKHR.BT2020_LINEAR_EXT -> "VK_COLOR_SPACE_BT2020_LINEAR_EXT";
            case VkColorSpaceKHR.BT709_LINEAR_EXT -> "VK_COLOR_SPACE_BT709_LINEAR_EXT";
            case VkColorSpaceKHR.BT709_NONLINEAR_EXT -> "VK_COLOR_SPACE_BT709_NONLINEAR_EXT";
            case VkColorSpaceKHR.DCI_P3_NONLINEAR_EXT -> "VK_COLOR_SPACE_DCI_P3_NONLINEAR_EXT";
            case VkColorSpaceKHR.DISPLAY_NATIVE_AMD -> "VK_COLOR_SPACE_DISPLAY_NATIVE_AMD";
            case VkColorSpaceKHR.DISPLAY_P3_LINEAR_EXT -> "VK_COLOR_SPACE_DISPLAY_P3_LINEAR_EXT";
            case VkColorSpaceKHR.DISPLAY_P3_NONLINEAR_EXT -> "VK_COLOR_SPACE_DISPLAY_P3_NONLINEAR_EXT";
            case VkColorSpaceKHR.DOLBYVISION_EXT -> "VK_COLOR_SPACE_DOLBYVISION_EXT";
            case VkColorSpaceKHR.EXTENDED_SRGB_LINEAR_EXT -> "VK_COLOR_SPACE_EXTENDED_SRGB_LINEAR_EXT";
            case VkColorSpaceKHR.EXTENDED_SRGB_NONLINEAR_EXT -> "VK_COLOR_SPACE_EXTENDED_SRGB_NONLINEAR_EXT";
            case VkColorSpaceKHR.HDR10_HLG_EXT -> "VK_COLOR_SPACE_HDR10_HLG_EXT";
            case VkColorSpaceKHR.HDR10_ST2084_EXT -> "VK_COLOR_SPACE_HDR10_ST2084_EXT";
            case VkColorSpaceKHR.PASS_THROUGH_EXT -> "VK_COLOR_SPACE_PASS_THROUGH_EXT";
            case VkColorSpaceKHR.SRGB_NONLINEAR -> "VK_COLOR_SPACE_SRGB_NONLINEAR_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkColorSpaceKHR() {}
}

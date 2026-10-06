package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplaySurfaceStereoTypeNV.html"><code>VkDisplaySurfaceStereoTypeNV</code></a>
public final class VkDisplaySurfaceStereoTypeNV {
    public static final int NONE = 0x0;
    public static final int ONBOARD_DIN = 0x1;
    public static final int HDMI_3D = 0x2;
    public static final int INBAND_DISPLAYPORT = 0x3;

    public static String explain(@EnumType(VkDisplaySurfaceStereoTypeNV.class) int value) {
        return switch (value) {
            case VkDisplaySurfaceStereoTypeNV.HDMI_3D -> "VK_DISPLAY_SURFACE_STEREO_TYPE_HDMI_3D_NV";
            case VkDisplaySurfaceStereoTypeNV.INBAND_DISPLAYPORT -> "VK_DISPLAY_SURFACE_STEREO_TYPE_INBAND_DISPLAYPORT_NV";
            case VkDisplaySurfaceStereoTypeNV.NONE -> "VK_DISPLAY_SURFACE_STEREO_TYPE_NONE_NV";
            case VkDisplaySurfaceStereoTypeNV.ONBOARD_DIN -> "VK_DISPLAY_SURFACE_STEREO_TYPE_ONBOARD_DIN_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDisplaySurfaceStereoTypeNV() {}
}

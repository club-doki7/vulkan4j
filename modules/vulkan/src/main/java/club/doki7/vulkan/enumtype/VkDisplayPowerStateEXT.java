package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPowerStateEXT.html"><code>VkDisplayPowerStateEXT</code></a>
public final class VkDisplayPowerStateEXT {
    public static final int OFF = 0x0;
    public static final int SUSPEND = 0x1;
    public static final int ON = 0x2;

    public static String explain(@EnumType(VkDisplayPowerStateEXT.class) int value) {
        return switch (value) {
            case VkDisplayPowerStateEXT.OFF -> "VK_DISPLAY_POWER_STATE_OFF_EXT";
            case VkDisplayPowerStateEXT.ON -> "VK_DISPLAY_POWER_STATE_ON_EXT";
            case VkDisplayPowerStateEXT.SUSPEND -> "VK_DISPLAY_POWER_STATE_SUSPEND_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDisplayPowerStateEXT() {}
}

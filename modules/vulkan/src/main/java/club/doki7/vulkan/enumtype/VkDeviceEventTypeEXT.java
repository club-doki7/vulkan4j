package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceEventTypeEXT.html"><code>VkDeviceEventTypeEXT</code></a>
public final class VkDeviceEventTypeEXT {
    public static final int DISPLAY_HOTPLUG = 0x0;

    public static String explain(@EnumType(VkDeviceEventTypeEXT.class) int value) {
        return switch (value) {
            case VkDeviceEventTypeEXT.DISPLAY_HOTPLUG -> "VK_DEVICE_EVENT_TYPE_DISPLAY_HOTPLUG_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceEventTypeEXT() {}
}

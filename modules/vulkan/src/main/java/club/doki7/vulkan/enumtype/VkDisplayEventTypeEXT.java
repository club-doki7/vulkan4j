package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayEventTypeEXT.html"><code>VkDisplayEventTypeEXT</code></a>
public final class VkDisplayEventTypeEXT {
    public static final int FIRST_PIXEL_OUT = 0x0;

    public static String explain(@EnumType(VkDisplayEventTypeEXT.class) int value) {
        return switch (value) {
            case VkDisplayEventTypeEXT.FIRST_PIXEL_OUT -> "VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDisplayEventTypeEXT() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFullScreenExclusiveEXT.html"><code>VkFullScreenExclusiveEXT</code></a>
public final class VkFullScreenExclusiveEXT {
    public static final int DEFAULT = 0x0;
    public static final int ALLOWED = 0x1;
    public static final int DISALLOWED = 0x2;
    public static final int APPLICATION_CONTROLLED = 0x3;

    public static String explain(@EnumType(VkFullScreenExclusiveEXT.class) int value) {
        return switch (value) {
            case VkFullScreenExclusiveEXT.ALLOWED -> "VK_FULL_SCREEN_EXCLUSIVE_ALLOWED_EXT";
            case VkFullScreenExclusiveEXT.APPLICATION_CONTROLLED -> "VK_FULL_SCREEN_EXCLUSIVE_APPLICATION_CONTROLLED_EXT";
            case VkFullScreenExclusiveEXT.DEFAULT -> "VK_FULL_SCREEN_EXCLUSIVE_DEFAULT_EXT";
            case VkFullScreenExclusiveEXT.DISALLOWED -> "VK_FULL_SCREEN_EXCLUSIVE_DISALLOWED_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFullScreenExclusiveEXT() {}
}

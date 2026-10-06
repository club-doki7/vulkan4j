package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildMicromapModeEXT.html"><code>VkBuildMicromapModeEXT</code></a>
public final class VkBuildMicromapModeEXT {
    public static final int BUILD = 0x0;

    public static String explain(@EnumType(VkBuildMicromapModeEXT.class) int value) {
        return switch (value) {
            case VkBuildMicromapModeEXT.BUILD -> "VK_BUILD_MICROMAP_MODE_BUILD_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBuildMicromapModeEXT() {}
}

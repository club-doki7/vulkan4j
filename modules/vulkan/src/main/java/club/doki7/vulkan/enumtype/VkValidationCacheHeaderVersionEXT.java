package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationCacheHeaderVersionEXT.html"><code>VkValidationCacheHeaderVersionEXT</code></a>
public final class VkValidationCacheHeaderVersionEXT {
    public static final int ONE = 0x1;

    public static String explain(@EnumType(VkValidationCacheHeaderVersionEXT.class) int value) {
        return switch (value) {
            case VkValidationCacheHeaderVersionEXT.ONE -> "VK_VALIDATION_CACHE_HEADER_VERSION_ONE_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkValidationCacheHeaderVersionEXT() {}
}

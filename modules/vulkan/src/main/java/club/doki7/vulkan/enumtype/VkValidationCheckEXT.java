package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationCheckEXT.html"><code>VkValidationCheckEXT</code></a>
public final class VkValidationCheckEXT {
    public static final int ALL = 0x0;
    public static final int SHADERS = 0x1;

    public static String explain(@EnumType(VkValidationCheckEXT.class) int value) {
        return switch (value) {
            case VkValidationCheckEXT.ALL -> "VK_VALIDATION_CHECK_ALL_EXT";
            case VkValidationCheckEXT.SHADERS -> "VK_VALIDATION_CHECK_SHADERS_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkValidationCheckEXT() {}
}

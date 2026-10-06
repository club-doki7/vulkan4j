package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFeatureDisableEXT.html"><code>VkValidationFeatureDisableEXT</code></a>
public final class VkValidationFeatureDisableEXT {
    public static final int ALL = 0x0;
    public static final int SHADERS = 0x1;
    public static final int THREAD_SAFETY = 0x2;
    public static final int API_PARAMETERS = 0x3;
    public static final int OBJECT_LIFETIMES = 0x4;
    public static final int CORE_CHECKS = 0x5;
    public static final int UNIQUE_HANDLES = 0x6;
    public static final int SHADER_VALIDATION_CACHE = 0x7;

    public static String explain(@EnumType(VkValidationFeatureDisableEXT.class) int value) {
        return switch (value) {
            case VkValidationFeatureDisableEXT.ALL -> "VK_VALIDATION_FEATURE_DISABLE_ALL_EXT";
            case VkValidationFeatureDisableEXT.API_PARAMETERS -> "VK_VALIDATION_FEATURE_DISABLE_API_PARAMETERS_EXT";
            case VkValidationFeatureDisableEXT.CORE_CHECKS -> "VK_VALIDATION_FEATURE_DISABLE_CORE_CHECKS_EXT";
            case VkValidationFeatureDisableEXT.OBJECT_LIFETIMES -> "VK_VALIDATION_FEATURE_DISABLE_OBJECT_LIFETIMES_EXT";
            case VkValidationFeatureDisableEXT.SHADERS -> "VK_VALIDATION_FEATURE_DISABLE_SHADERS_EXT";
            case VkValidationFeatureDisableEXT.SHADER_VALIDATION_CACHE -> "VK_VALIDATION_FEATURE_DISABLE_SHADER_VALIDATION_CACHE_EXT";
            case VkValidationFeatureDisableEXT.THREAD_SAFETY -> "VK_VALIDATION_FEATURE_DISABLE_THREAD_SAFETY_EXT";
            case VkValidationFeatureDisableEXT.UNIQUE_HANDLES -> "VK_VALIDATION_FEATURE_DISABLE_UNIQUE_HANDLES_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkValidationFeatureDisableEXT() {}
}

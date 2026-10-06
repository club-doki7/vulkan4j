package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFeatureEnableEXT.html"><code>VkValidationFeatureEnableEXT</code></a>
public final class VkValidationFeatureEnableEXT {
    public static final int GPU_ASSISTED = 0x0;
    public static final int GPU_ASSISTED_RESERVE_BINDING_SLOT = 0x1;
    public static final int BEST_PRACTICES = 0x2;
    public static final int DEBUG_PRINTF = 0x3;
    public static final int SYNCHRONIZATION_VALIDATION = 0x4;

    public static String explain(@EnumType(VkValidationFeatureEnableEXT.class) int value) {
        return switch (value) {
            case VkValidationFeatureEnableEXT.BEST_PRACTICES -> "VK_VALIDATION_FEATURE_ENABLE_BEST_PRACTICES_EXT";
            case VkValidationFeatureEnableEXT.DEBUG_PRINTF -> "VK_VALIDATION_FEATURE_ENABLE_DEBUG_PRINTF_EXT";
            case VkValidationFeatureEnableEXT.GPU_ASSISTED -> "VK_VALIDATION_FEATURE_ENABLE_GPU_ASSISTED_EXT";
            case VkValidationFeatureEnableEXT.GPU_ASSISTED_RESERVE_BINDING_SLOT -> "VK_VALIDATION_FEATURE_ENABLE_GPU_ASSISTED_RESERVE_BINDING_SLOT_EXT";
            case VkValidationFeatureEnableEXT.SYNCHRONIZATION_VALIDATION -> "VK_VALIDATION_FEATURE_ENABLE_SYNCHRONIZATION_VALIDATION_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkValidationFeatureEnableEXT() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerSettingTypeEXT.html"><code>VkLayerSettingTypeEXT</code></a>
public final class VkLayerSettingTypeEXT {
    public static final int BOOL32 = 0x0;
    public static final int INT32 = 0x1;
    public static final int INT64 = 0x2;
    public static final int UINT32 = 0x3;
    public static final int UINT64 = 0x4;
    public static final int FLOAT32 = 0x5;
    public static final int FLOAT64 = 0x6;
    public static final int STRING = 0x7;

    public static String explain(@EnumType(VkLayerSettingTypeEXT.class) int value) {
        return switch (value) {
            case VkLayerSettingTypeEXT.BOOL32 -> "VK_LAYER_SETTING_TYPE_BOOL32_EXT";
            case VkLayerSettingTypeEXT.FLOAT32 -> "VK_LAYER_SETTING_TYPE_FLOAT32_EXT";
            case VkLayerSettingTypeEXT.FLOAT64 -> "VK_LAYER_SETTING_TYPE_FLOAT64_EXT";
            case VkLayerSettingTypeEXT.INT32 -> "VK_LAYER_SETTING_TYPE_INT32_EXT";
            case VkLayerSettingTypeEXT.INT64 -> "VK_LAYER_SETTING_TYPE_INT64_EXT";
            case VkLayerSettingTypeEXT.STRING -> "VK_LAYER_SETTING_TYPE_STRING_EXT";
            case VkLayerSettingTypeEXT.UINT32 -> "VK_LAYER_SETTING_TYPE_UINT32_EXT";
            case VkLayerSettingTypeEXT.UINT64 -> "VK_LAYER_SETTING_TYPE_UINT64_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkLayerSettingTypeEXT() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapTypeEXT.html"><code>VkMicromapTypeEXT</code></a>
public final class VkMicromapTypeEXT {
    public static final int OPACITY_MICROMAP = 0x0;
    public static final int DISPLACEMENT_MICROMAP_NV = 0x3ba0d8c8;

    public static String explain(@EnumType(VkMicromapTypeEXT.class) int value) {
        return switch (value) {
            case VkMicromapTypeEXT.DISPLACEMENT_MICROMAP_NV -> "VK_MICROMAP_TYPE_DISPLACEMENT_MICROMAP_NV";
            case VkMicromapTypeEXT.OPACITY_MICROMAP -> "VK_MICROMAP_TYPE_OPACITY_MICROMAP_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMicromapTypeEXT() {}
}

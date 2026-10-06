package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpacityMicromapFormatKHR.html"><code>VkOpacityMicromapFormatKHR</code></a>
public final class VkOpacityMicromapFormatKHR {
    public static final int _2_STATE = 0x1;
    public static final int _4_STATE = 0x2;

    public static String explain(@EnumType(VkOpacityMicromapFormatKHR.class) int value) {
        return switch (value) {
            case VkOpacityMicromapFormatKHR._2_STATE -> "VK_OPACITY_MICROMAP_FORMAT_2_STATE_KHR";
            case VkOpacityMicromapFormatKHR._4_STATE -> "VK_OPACITY_MICROMAP_FORMAT_4_STATE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOpacityMicromapFormatKHR() {}
}

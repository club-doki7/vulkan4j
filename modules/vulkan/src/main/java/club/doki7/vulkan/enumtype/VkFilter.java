package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFilter.html"><code>VkFilter</code></a>
public final class VkFilter {
    public static final int NEAREST = 0x0;
    public static final int LINEAR = 0x1;
    public static final int CUBIC_EXT = 0x3b9b0498;

    public static String explain(@EnumType(VkFilter.class) int value) {
        return switch (value) {
            case VkFilter.CUBIC_EXT -> "VK_FILTER_CUBIC_EXT";
            case VkFilter.LINEAR -> "VK_FILTER_LINEAR";
            case VkFilter.NEAREST -> "VK_FILTER_NEAREST";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFilter() {}
}

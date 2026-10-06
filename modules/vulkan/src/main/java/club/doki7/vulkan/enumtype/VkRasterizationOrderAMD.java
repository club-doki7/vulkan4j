package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRasterizationOrderAMD.html"><code>VkRasterizationOrderAMD</code></a>
public final class VkRasterizationOrderAMD {
    public static final int STRICT = 0x0;
    public static final int RELAXED = 0x1;

    public static String explain(@EnumType(VkRasterizationOrderAMD.class) int value) {
        return switch (value) {
            case VkRasterizationOrderAMD.RELAXED -> "VK_RASTERIZATION_ORDER_RELAXED_AMD";
            case VkRasterizationOrderAMD.STRICT -> "VK_RASTERIZATION_ORDER_STRICT_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRasterizationOrderAMD() {}
}

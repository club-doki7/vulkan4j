package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerYcbcrRange.html"><code>VkSamplerYcbcrRange</code></a>
public final class VkSamplerYcbcrRange {
    public static final int ITU_FULL = 0x0;
    public static final int ITU_NARROW = 0x1;

    public static String explain(@EnumType(VkSamplerYcbcrRange.class) int value) {
        return switch (value) {
            case VkSamplerYcbcrRange.ITU_FULL -> "VK_SAMPLER_YCBCR_RANGE_ITU_FULL";
            case VkSamplerYcbcrRange.ITU_NARROW -> "VK_SAMPLER_YCBCR_RANGE_ITU_NARROW";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerYcbcrRange() {}
}

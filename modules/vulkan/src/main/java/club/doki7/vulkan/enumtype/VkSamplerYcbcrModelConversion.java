package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerYcbcrModelConversion.html"><code>VkSamplerYcbcrModelConversion</code></a>
public final class VkSamplerYcbcrModelConversion {
    public static final int RGB_IDENTITY = 0x0;
    public static final int YCBCR_IDENTITY = 0x1;
    public static final int YCBCR_709 = 0x2;
    public static final int YCBCR_601 = 0x3;
    public static final int YCBCR_2020 = 0x4;

    public static String explain(@EnumType(VkSamplerYcbcrModelConversion.class) int value) {
        return switch (value) {
            case VkSamplerYcbcrModelConversion.RGB_IDENTITY -> "VK_SAMPLER_YCBCR_MODEL_CONVERSION_RGB_IDENTITY";
            case VkSamplerYcbcrModelConversion.YCBCR_2020 -> "VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_2020";
            case VkSamplerYcbcrModelConversion.YCBCR_601 -> "VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_601";
            case VkSamplerYcbcrModelConversion.YCBCR_709 -> "VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_709";
            case VkSamplerYcbcrModelConversion.YCBCR_IDENTITY -> "VK_SAMPLER_YCBCR_MODEL_CONVERSION_YCBCR_IDENTITY";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerYcbcrModelConversion() {}
}

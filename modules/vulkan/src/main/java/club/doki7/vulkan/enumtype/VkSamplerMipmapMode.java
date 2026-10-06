package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerMipmapMode.html"><code>VkSamplerMipmapMode</code></a>
public final class VkSamplerMipmapMode {
    public static final int NEAREST = 0x0;
    public static final int LINEAR = 0x1;

    public static String explain(@EnumType(VkSamplerMipmapMode.class) int value) {
        return switch (value) {
            case VkSamplerMipmapMode.LINEAR -> "VK_SAMPLER_MIPMAP_MODE_LINEAR";
            case VkSamplerMipmapMode.NEAREST -> "VK_SAMPLER_MIPMAP_MODE_NEAREST";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerMipmapMode() {}
}

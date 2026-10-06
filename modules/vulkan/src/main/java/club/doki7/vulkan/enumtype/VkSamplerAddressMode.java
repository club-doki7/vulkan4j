package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerAddressMode.html"><code>VkSamplerAddressMode</code></a>
public final class VkSamplerAddressMode {
    public static final int REPEAT = 0x0;
    public static final int MIRRORED_REPEAT = 0x1;
    public static final int CLAMP_TO_EDGE = 0x2;
    public static final int CLAMP_TO_BORDER = 0x3;
    public static final int MIRROR_CLAMP_TO_EDGE = 0x4;

    public static String explain(@EnumType(VkSamplerAddressMode.class) int value) {
        return switch (value) {
            case VkSamplerAddressMode.CLAMP_TO_BORDER -> "VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_BORDER";
            case VkSamplerAddressMode.CLAMP_TO_EDGE -> "VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE";
            case VkSamplerAddressMode.MIRRORED_REPEAT -> "VK_SAMPLER_ADDRESS_MODE_MIRRORED_REPEAT";
            case VkSamplerAddressMode.MIRROR_CLAMP_TO_EDGE -> "VK_SAMPLER_ADDRESS_MODE_MIRROR_CLAMP_TO_EDGE";
            case VkSamplerAddressMode.REPEAT -> "VK_SAMPLER_ADDRESS_MODE_REPEAT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerAddressMode() {}
}

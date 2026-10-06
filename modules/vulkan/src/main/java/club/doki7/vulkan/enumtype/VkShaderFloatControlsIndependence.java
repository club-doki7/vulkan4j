package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderFloatControlsIndependence.html"><code>VkShaderFloatControlsIndependence</code></a>
public final class VkShaderFloatControlsIndependence {
    public static final int _32_BIT_ONLY = 0x0;
    public static final int ALL = 0x1;
    public static final int NONE = 0x2;

    public static String explain(@EnumType(VkShaderFloatControlsIndependence.class) int value) {
        return switch (value) {
            case VkShaderFloatControlsIndependence._32_BIT_ONLY -> "VK_SHADER_FLOAT_CONTROLS_INDEPENDENCE_32_BIT_ONLY";
            case VkShaderFloatControlsIndependence.ALL -> "VK_SHADER_FLOAT_CONTROLS_INDEPENDENCE_ALL";
            case VkShaderFloatControlsIndependence.NONE -> "VK_SHADER_FLOAT_CONTROLS_INDEPENDENCE_NONE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkShaderFloatControlsIndependence() {}
}

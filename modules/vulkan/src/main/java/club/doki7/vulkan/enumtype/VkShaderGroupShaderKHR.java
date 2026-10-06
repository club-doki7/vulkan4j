package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderGroupShaderKHR.html"><code>VkShaderGroupShaderKHR</code></a>
public final class VkShaderGroupShaderKHR {
    public static final int GENERAL = 0x0;
    public static final int CLOSEST_HIT = 0x1;
    public static final int ANY_HIT = 0x2;
    public static final int INTERSECTION = 0x3;

    public static String explain(@EnumType(VkShaderGroupShaderKHR.class) int value) {
        return switch (value) {
            case VkShaderGroupShaderKHR.ANY_HIT -> "VK_SHADER_GROUP_SHADER_ANY_HIT_KHR";
            case VkShaderGroupShaderKHR.CLOSEST_HIT -> "VK_SHADER_GROUP_SHADER_CLOSEST_HIT_KHR";
            case VkShaderGroupShaderKHR.GENERAL -> "VK_SHADER_GROUP_SHADER_GENERAL_KHR";
            case VkShaderGroupShaderKHR.INTERSECTION -> "VK_SHADER_GROUP_SHADER_INTERSECTION_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkShaderGroupShaderKHR() {}
}

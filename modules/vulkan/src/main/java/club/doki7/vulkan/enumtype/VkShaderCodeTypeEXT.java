package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderCodeTypeEXT.html"><code>VkShaderCodeTypeEXT</code></a>
public final class VkShaderCodeTypeEXT {
    public static final int BINARY = 0x0;
    public static final int SPIRV = 0x1;

    public static String explain(@EnumType(VkShaderCodeTypeEXT.class) int value) {
        return switch (value) {
            case VkShaderCodeTypeEXT.BINARY -> "VK_SHADER_CODE_TYPE_BINARY_EXT";
            case VkShaderCodeTypeEXT.SPIRV -> "VK_SHADER_CODE_TYPE_SPIRV_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkShaderCodeTypeEXT() {}
}

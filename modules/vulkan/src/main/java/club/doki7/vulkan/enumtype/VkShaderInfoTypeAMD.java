package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderInfoTypeAMD.html"><code>VkShaderInfoTypeAMD</code></a>
public final class VkShaderInfoTypeAMD {
    public static final int STATISTICS = 0x0;
    public static final int BINARY = 0x1;
    public static final int DISASSEMBLY = 0x2;

    public static String explain(@EnumType(VkShaderInfoTypeAMD.class) int value) {
        return switch (value) {
            case VkShaderInfoTypeAMD.BINARY -> "VK_SHADER_INFO_TYPE_BINARY_AMD";
            case VkShaderInfoTypeAMD.DISASSEMBLY -> "VK_SHADER_INFO_TYPE_DISASSEMBLY_AMD";
            case VkShaderInfoTypeAMD.STATISTICS -> "VK_SHADER_INFO_TYPE_STATISTICS_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkShaderInfoTypeAMD() {}
}

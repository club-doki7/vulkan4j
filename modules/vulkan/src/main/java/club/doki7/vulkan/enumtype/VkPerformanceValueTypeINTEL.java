package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueTypeINTEL.html"><code>VkPerformanceValueTypeINTEL</code></a>
public final class VkPerformanceValueTypeINTEL {
    public static final int UINT32 = 0x0;
    public static final int UINT64 = 0x1;
    public static final int FLOAT = 0x2;
    public static final int BOOL = 0x3;
    public static final int STRING = 0x4;

    public static String explain(@EnumType(VkPerformanceValueTypeINTEL.class) int value) {
        return switch (value) {
            case VkPerformanceValueTypeINTEL.BOOL -> "VK_PERFORMANCE_VALUE_TYPE_BOOL_INTEL";
            case VkPerformanceValueTypeINTEL.FLOAT -> "VK_PERFORMANCE_VALUE_TYPE_FLOAT_INTEL";
            case VkPerformanceValueTypeINTEL.STRING -> "VK_PERFORMANCE_VALUE_TYPE_STRING_INTEL";
            case VkPerformanceValueTypeINTEL.UINT32 -> "VK_PERFORMANCE_VALUE_TYPE_UINT32_INTEL";
            case VkPerformanceValueTypeINTEL.UINT64 -> "VK_PERFORMANCE_VALUE_TYPE_UINT64_INTEL";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPerformanceValueTypeINTEL() {}
}

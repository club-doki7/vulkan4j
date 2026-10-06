package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingLssPrimitiveEndCapsModeNV.html"><code>VkRayTracingLssPrimitiveEndCapsModeNV</code></a>
public final class VkRayTracingLssPrimitiveEndCapsModeNV {
    public static final int NONE = 0x0;
    public static final int CHAINED = 0x1;

    public static String explain(@EnumType(VkRayTracingLssPrimitiveEndCapsModeNV.class) int value) {
        return switch (value) {
            case VkRayTracingLssPrimitiveEndCapsModeNV.CHAINED -> "VK_RAY_TRACING_LSS_PRIMITIVE_END_CAPS_MODE_CHAINED_NV";
            case VkRayTracingLssPrimitiveEndCapsModeNV.NONE -> "VK_RAY_TRACING_LSS_PRIMITIVE_END_CAPS_MODE_NONE_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRayTracingLssPrimitiveEndCapsModeNV() {}
}

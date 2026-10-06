package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingShaderGroupTypeKHR.html"><code>VkRayTracingShaderGroupTypeKHR</code></a>
public final class VkRayTracingShaderGroupTypeKHR {
    public static final int GENERAL = 0x0;
    public static final int TRIANGLES_HIT_GROUP = 0x1;
    public static final int PROCEDURAL_HIT_GROUP = 0x2;

    public static String explain(@EnumType(VkRayTracingShaderGroupTypeKHR.class) int value) {
        return switch (value) {
            case VkRayTracingShaderGroupTypeKHR.GENERAL -> "VK_RAY_TRACING_SHADER_GROUP_TYPE_GENERAL_KHR";
            case VkRayTracingShaderGroupTypeKHR.PROCEDURAL_HIT_GROUP -> "VK_RAY_TRACING_SHADER_GROUP_TYPE_PROCEDURAL_HIT_GROUP_KHR";
            case VkRayTracingShaderGroupTypeKHR.TRIANGLES_HIT_GROUP -> "VK_RAY_TRACING_SHADER_GROUP_TYPE_TRIANGLES_HIT_GROUP_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRayTracingShaderGroupTypeKHR() {}
}

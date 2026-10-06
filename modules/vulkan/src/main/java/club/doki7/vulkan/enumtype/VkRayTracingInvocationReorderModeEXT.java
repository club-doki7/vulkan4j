package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingInvocationReorderModeEXT.html"><code>VkRayTracingInvocationReorderModeEXT</code></a>
public final class VkRayTracingInvocationReorderModeEXT {
    public static final int NONE = 0x0;
    public static final int REORDER = 0x1;

    public static String explain(@EnumType(VkRayTracingInvocationReorderModeEXT.class) int value) {
        return switch (value) {
            case VkRayTracingInvocationReorderModeEXT.NONE -> "VK_RAY_TRACING_INVOCATION_REORDER_MODE_NONE_EXT";
            case VkRayTracingInvocationReorderModeEXT.REORDER -> "VK_RAY_TRACING_INVOCATION_REORDER_MODE_REORDER_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRayTracingInvocationReorderModeEXT() {}
}

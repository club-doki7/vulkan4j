package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDirectDriverLoadingModeLUNARG.html"><code>VkDirectDriverLoadingModeLUNARG</code></a>
public final class VkDirectDriverLoadingModeLUNARG {
    public static final int EXCLUSIVE = 0x0;
    public static final int INCLUSIVE = 0x1;

    public static String explain(@EnumType(VkDirectDriverLoadingModeLUNARG.class) int value) {
        return switch (value) {
            case VkDirectDriverLoadingModeLUNARG.EXCLUSIVE -> "VK_DIRECT_DRIVER_LOADING_MODE_EXCLUSIVE_LUNARG";
            case VkDirectDriverLoadingModeLUNARG.INCLUSIVE -> "VK_DIRECT_DRIVER_LOADING_MODE_INCLUSIVE_LUNARG";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDirectDriverLoadingModeLUNARG() {}
}

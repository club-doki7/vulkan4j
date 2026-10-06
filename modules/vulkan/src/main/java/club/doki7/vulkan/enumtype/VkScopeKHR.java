package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkScopeKHR.html"><code>VkScopeKHR</code></a>
public final class VkScopeKHR {
    public static final int DEVICE = 0x1;
    public static final int WORKGROUP = 0x2;
    public static final int SUBGROUP = 0x3;
    public static final int QUEUE_FAMILY = 0x5;

    public static String explain(@EnumType(VkScopeKHR.class) int value) {
        return switch (value) {
            case VkScopeKHR.DEVICE -> "VK_SCOPE_DEVICE_KHR";
            case VkScopeKHR.QUEUE_FAMILY -> "VK_SCOPE_QUEUE_FAMILY_KHR";
            case VkScopeKHR.SUBGROUP -> "VK_SCOPE_SUBGROUP_KHR";
            case VkScopeKHR.WORKGROUP -> "VK_SCOPE_WORKGROUP_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkScopeKHR() {}
}

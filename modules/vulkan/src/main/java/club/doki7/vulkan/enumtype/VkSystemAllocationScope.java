package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSystemAllocationScope.html"><code>VkSystemAllocationScope</code></a>
public final class VkSystemAllocationScope {
    public static final int COMMAND = 0x0;
    public static final int OBJECT = 0x1;
    public static final int CACHE = 0x2;
    public static final int DEVICE = 0x3;
    public static final int INSTANCE = 0x4;

    public static String explain(@EnumType(VkSystemAllocationScope.class) int value) {
        return switch (value) {
            case VkSystemAllocationScope.CACHE -> "VK_SYSTEM_ALLOCATION_SCOPE_CACHE";
            case VkSystemAllocationScope.COMMAND -> "VK_SYSTEM_ALLOCATION_SCOPE_COMMAND";
            case VkSystemAllocationScope.DEVICE -> "VK_SYSTEM_ALLOCATION_SCOPE_DEVICE";
            case VkSystemAllocationScope.INSTANCE -> "VK_SYSTEM_ALLOCATION_SCOPE_INSTANCE";
            case VkSystemAllocationScope.OBJECT -> "VK_SYSTEM_ALLOCATION_SCOPE_OBJECT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSystemAllocationScope() {}
}

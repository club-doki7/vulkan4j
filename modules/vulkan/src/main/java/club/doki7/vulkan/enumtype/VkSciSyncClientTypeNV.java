package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSciSyncClientTypeNV.html"><code>VkSciSyncClientTypeNV</code></a>
public final class VkSciSyncClientTypeNV {
    public static final int SIGNALER = 0x0;
    public static final int WAITER = 0x1;
    public static final int SIGNALER_WAITER = 0x2;

    public static String explain(@EnumType(VkSciSyncClientTypeNV.class) int value) {
        return switch (value) {
            case VkSciSyncClientTypeNV.SIGNALER -> "VK_SCI_SYNC_CLIENT_TYPE_SIGNALER_NV";
            case VkSciSyncClientTypeNV.SIGNALER_WAITER -> "VK_SCI_SYNC_CLIENT_TYPE_SIGNALER_WAITER_NV";
            case VkSciSyncClientTypeNV.WAITER -> "VK_SCI_SYNC_CLIENT_TYPE_WAITER_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSciSyncClientTypeNV() {}
}

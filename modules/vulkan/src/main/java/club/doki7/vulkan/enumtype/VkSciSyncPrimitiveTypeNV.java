package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSciSyncPrimitiveTypeNV.html"><code>VkSciSyncPrimitiveTypeNV</code></a>
public final class VkSciSyncPrimitiveTypeNV {
    public static final int FENCE = 0x0;
    public static final int SEMAPHORE = 0x1;

    public static String explain(@EnumType(VkSciSyncPrimitiveTypeNV.class) int value) {
        return switch (value) {
            case VkSciSyncPrimitiveTypeNV.FENCE -> "VK_SCI_SYNC_PRIMITIVE_TYPE_FENCE_NV";
            case VkSciSyncPrimitiveTypeNV.SEMAPHORE -> "VK_SCI_SYNC_PRIMITIVE_TYPE_SEMAPHORE_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSciSyncPrimitiveTypeNV() {}
}

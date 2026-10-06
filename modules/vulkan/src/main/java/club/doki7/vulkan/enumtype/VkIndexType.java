package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndexType.html"><code>VkIndexType</code></a>
public final class VkIndexType {
    public static final int UINT16 = 0x0;
    public static final int UINT32 = 0x1;
    public static final int UINT8 = 0x3b9ed528;
    public static final int NONE_KHR = 0x3b9d4e88;

    public static String explain(@EnumType(VkIndexType.class) int value) {
        return switch (value) {
            case VkIndexType.NONE_KHR -> "VK_INDEX_TYPE_NONE_KHR";
            case VkIndexType.UINT16 -> "VK_INDEX_TYPE_UINT16";
            case VkIndexType.UINT32 -> "VK_INDEX_TYPE_UINT32";
            case VkIndexType.UINT8 -> "VK_INDEX_TYPE_UINT8";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndexType() {}
}

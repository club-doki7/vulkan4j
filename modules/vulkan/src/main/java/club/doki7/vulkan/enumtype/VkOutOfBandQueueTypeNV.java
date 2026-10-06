package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOutOfBandQueueTypeNV.html"><code>VkOutOfBandQueueTypeNV</code></a>
public final class VkOutOfBandQueueTypeNV {
    public static final int RENDER = 0x0;
    public static final int PRESENT = 0x1;

    public static String explain(@EnumType(VkOutOfBandQueueTypeNV.class) int value) {
        return switch (value) {
            case VkOutOfBandQueueTypeNV.PRESENT -> "VK_OUT_OF_BAND_QUEUE_TYPE_PRESENT_NV";
            case VkOutOfBandQueueTypeNV.RENDER -> "VK_OUT_OF_BAND_QUEUE_TYPE_RENDER_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkOutOfBandQueueTypeNV() {}
}

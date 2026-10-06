package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkChromaLocation.html"><code>VkChromaLocation</code></a>
public final class VkChromaLocation {
    public static final int COSITED_EVEN = 0x0;
    public static final int MIDPOINT = 0x1;

    public static String explain(@EnumType(VkChromaLocation.class) int value) {
        return switch (value) {
            case VkChromaLocation.COSITED_EVEN -> "VK_CHROMA_LOCATION_COSITED_EVEN";
            case VkChromaLocation.MIDPOINT -> "VK_CHROMA_LOCATION_MIDPOINT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkChromaLocation() {}
}

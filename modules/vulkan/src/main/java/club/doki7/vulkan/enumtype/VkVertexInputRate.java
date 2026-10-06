package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputRate.html"><code>VkVertexInputRate</code></a>
public final class VkVertexInputRate {
    public static final int VERTEX = 0x0;
    public static final int INSTANCE = 0x1;

    public static String explain(@EnumType(VkVertexInputRate.class) int value) {
        return switch (value) {
            case VkVertexInputRate.INSTANCE -> "VK_VERTEX_INPUT_RATE_INSTANCE";
            case VkVertexInputRate.VERTEX -> "VK_VERTEX_INPUT_RATE_VERTEX";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVertexInputRate() {}
}

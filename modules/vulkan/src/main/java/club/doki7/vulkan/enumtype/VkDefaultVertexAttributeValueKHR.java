package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDefaultVertexAttributeValueKHR.html"><code>VkDefaultVertexAttributeValueKHR</code></a>
public final class VkDefaultVertexAttributeValueKHR {
    public static final int ZERO_ZERO_ZERO_ZERO = 0x0;
    public static final int ZERO_ZERO_ZERO_ONE = 0x1;

    public static String explain(@EnumType(VkDefaultVertexAttributeValueKHR.class) int value) {
        return switch (value) {
            case VkDefaultVertexAttributeValueKHR.ZERO_ZERO_ZERO_ONE -> "VK_DEFAULT_VERTEX_ATTRIBUTE_VALUE_ZERO_ZERO_ZERO_ONE_KHR";
            case VkDefaultVertexAttributeValueKHR.ZERO_ZERO_ZERO_ZERO -> "VK_DEFAULT_VERTEX_ATTRIBUTE_VALUE_ZERO_ZERO_ZERO_ZERO_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDefaultVertexAttributeValueKHR() {}
}

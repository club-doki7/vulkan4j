package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPrimitiveTopology.html"><code>VkPrimitiveTopology</code></a>
public final class VkPrimitiveTopology {
    public static final int POINT_LIST = 0x0;
    public static final int LINE_LIST = 0x1;
    public static final int LINE_STRIP = 0x2;
    public static final int TRIANGLE_LIST = 0x3;
    public static final int TRIANGLE_STRIP = 0x4;
    public static final int TRIANGLE_FAN = 0x5;
    public static final int LINE_LIST_WITH_ADJACENCY = 0x6;
    public static final int LINE_STRIP_WITH_ADJACENCY = 0x7;
    public static final int TRIANGLE_LIST_WITH_ADJACENCY = 0x8;
    public static final int TRIANGLE_STRIP_WITH_ADJACENCY = 0x9;
    public static final int PATCH_LIST = 0xa;

    public static String explain(@EnumType(VkPrimitiveTopology.class) int value) {
        return switch (value) {
            case VkPrimitiveTopology.LINE_LIST -> "VK_PRIMITIVE_TOPOLOGY_LINE_LIST";
            case VkPrimitiveTopology.LINE_LIST_WITH_ADJACENCY -> "VK_PRIMITIVE_TOPOLOGY_LINE_LIST_WITH_ADJACENCY";
            case VkPrimitiveTopology.LINE_STRIP -> "VK_PRIMITIVE_TOPOLOGY_LINE_STRIP";
            case VkPrimitiveTopology.LINE_STRIP_WITH_ADJACENCY -> "VK_PRIMITIVE_TOPOLOGY_LINE_STRIP_WITH_ADJACENCY";
            case VkPrimitiveTopology.PATCH_LIST -> "VK_PRIMITIVE_TOPOLOGY_PATCH_LIST";
            case VkPrimitiveTopology.POINT_LIST -> "VK_PRIMITIVE_TOPOLOGY_POINT_LIST";
            case VkPrimitiveTopology.TRIANGLE_FAN -> "VK_PRIMITIVE_TOPOLOGY_TRIANGLE_FAN";
            case VkPrimitiveTopology.TRIANGLE_LIST -> "VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST";
            case VkPrimitiveTopology.TRIANGLE_LIST_WITH_ADJACENCY -> "VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST_WITH_ADJACENCY";
            case VkPrimitiveTopology.TRIANGLE_STRIP -> "VK_PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP";
            case VkPrimitiveTopology.TRIANGLE_STRIP_WITH_ADJACENCY -> "VK_PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP_WITH_ADJACENCY";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPrimitiveTopology() {}
}

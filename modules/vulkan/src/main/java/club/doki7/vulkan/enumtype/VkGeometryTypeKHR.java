package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryTypeKHR.html"><code>VkGeometryTypeKHR</code></a>
public final class VkGeometryTypeKHR {
    public static final int TRIANGLES = 0x0;
    public static final int AABBS = 0x1;
    public static final int INSTANCES = 0x2;
    public static final int SPHERES_NV = 0x3ba155cc;
    public static final int LINEAR_SWEPT_SPHERES_NV = 0x3ba155cd;
    public static final int DENSE_GEOMETRY_FORMAT_TRIANGLES_AMDX = 0x3ba21530;
    public static final int MICROMAP = 0x3ba44b98;

    public static String explain(@EnumType(VkGeometryTypeKHR.class) int value) {
        return switch (value) {
            case VkGeometryTypeKHR.AABBS -> "VK_GEOMETRY_TYPE_AABBS_KHR";
            case VkGeometryTypeKHR.DENSE_GEOMETRY_FORMAT_TRIANGLES_AMDX -> "VK_GEOMETRY_TYPE_DENSE_GEOMETRY_FORMAT_TRIANGLES_AMDX";
            case VkGeometryTypeKHR.INSTANCES -> "VK_GEOMETRY_TYPE_INSTANCES_KHR";
            case VkGeometryTypeKHR.LINEAR_SWEPT_SPHERES_NV -> "VK_GEOMETRY_TYPE_LINEAR_SWEPT_SPHERES_NV";
            case VkGeometryTypeKHR.MICROMAP -> "VK_GEOMETRY_TYPE_MICROMAP_KHR";
            case VkGeometryTypeKHR.SPHERES_NV -> "VK_GEOMETRY_TYPE_SPHERES_NV";
            case VkGeometryTypeKHR.TRIANGLES -> "VK_GEOMETRY_TYPE_TRIANGLES_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGeometryTypeKHR() {}
}

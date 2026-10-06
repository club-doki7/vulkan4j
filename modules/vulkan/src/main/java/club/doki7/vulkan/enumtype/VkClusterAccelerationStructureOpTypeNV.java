package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureOpTypeNV.html"><code>VkClusterAccelerationStructureOpTypeNV</code></a>
public final class VkClusterAccelerationStructureOpTypeNV {
    public static final int MOVE_OBJECTS = 0x0;
    public static final int BUILD_CLUSTERS_BOTTOM_LEVEL = 0x1;
    public static final int BUILD_TRIANGLE_CLUSTER = 0x2;
    public static final int BUILD_TRIANGLE_CLUSTER_TEMPLATE = 0x3;
    public static final int INSTANTIATE_TRIANGLE_CLUSTER = 0x4;
    public static final int GET_CLUSTER_TEMPLATE_INDICES = 0x5;

    public static String explain(@EnumType(VkClusterAccelerationStructureOpTypeNV.class) int value) {
        return switch (value) {
            case VkClusterAccelerationStructureOpTypeNV.BUILD_CLUSTERS_BOTTOM_LEVEL -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_BUILD_CLUSTERS_BOTTOM_LEVEL_NV";
            case VkClusterAccelerationStructureOpTypeNV.BUILD_TRIANGLE_CLUSTER -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_BUILD_TRIANGLE_CLUSTER_NV";
            case VkClusterAccelerationStructureOpTypeNV.BUILD_TRIANGLE_CLUSTER_TEMPLATE -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_BUILD_TRIANGLE_CLUSTER_TEMPLATE_NV";
            case VkClusterAccelerationStructureOpTypeNV.GET_CLUSTER_TEMPLATE_INDICES -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_GET_CLUSTER_TEMPLATE_INDICES_NV";
            case VkClusterAccelerationStructureOpTypeNV.INSTANTIATE_TRIANGLE_CLUSTER -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_INSTANTIATE_TRIANGLE_CLUSTER_NV";
            case VkClusterAccelerationStructureOpTypeNV.MOVE_OBJECTS -> "VK_CLUSTER_ACCELERATION_STRUCTURE_OP_TYPE_MOVE_OBJECTS_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkClusterAccelerationStructureOpTypeNV() {}
}

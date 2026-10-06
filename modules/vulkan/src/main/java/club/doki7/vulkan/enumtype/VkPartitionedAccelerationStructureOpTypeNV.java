package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureOpTypeNV.html"><code>VkPartitionedAccelerationStructureOpTypeNV</code></a>
public final class VkPartitionedAccelerationStructureOpTypeNV {
    public static final int WRITE_INSTANCE = 0x0;
    public static final int UPDATE_INSTANCE = 0x1;
    public static final int WRITE_PARTITION_TRANSLATION = 0x2;

    public static String explain(@EnumType(VkPartitionedAccelerationStructureOpTypeNV.class) int value) {
        return switch (value) {
            case VkPartitionedAccelerationStructureOpTypeNV.UPDATE_INSTANCE -> "VK_PARTITIONED_ACCELERATION_STRUCTURE_OP_TYPE_UPDATE_INSTANCE_NV";
            case VkPartitionedAccelerationStructureOpTypeNV.WRITE_INSTANCE -> "VK_PARTITIONED_ACCELERATION_STRUCTURE_OP_TYPE_WRITE_INSTANCE_NV";
            case VkPartitionedAccelerationStructureOpTypeNV.WRITE_PARTITION_TRANSLATION -> "VK_PARTITIONED_ACCELERATION_STRUCTURE_OP_TYPE_WRITE_PARTITION_TRANSLATION_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPartitionedAccelerationStructureOpTypeNV() {}
}

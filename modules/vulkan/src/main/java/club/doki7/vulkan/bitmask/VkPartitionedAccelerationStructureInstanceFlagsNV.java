package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureInstanceFlagsNV.html"><code>VkPartitionedAccelerationStructureInstanceFlagsNV</code></a>
public final class VkPartitionedAccelerationStructureInstanceFlagsNV {
    public static final int FLAG_ENABLE_EXPLICIT_BOUNDING_BOX = 0x10;
    public static final int FLAG_FORCE_NO_OPAQUE = 0x8;
    public static final int FLAG_FORCE_OPAQUE = 0x4;
    public static final int FLAG_TRIANGLE_FACING_CULL_DISABLE = 0x1;
    public static final int FLAG_TRIANGLE_FLIP_FACING = 0x2;

    public static String explain(@Bitmask(VkPartitionedAccelerationStructureInstanceFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FLAG_ENABLE_EXPLICIT_BOUNDING_BOX) != 0) {
            detectedFlagBits.add("VK_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCE_FLAG_ENABLE_EXPLICIT_BOUNDING_BOX_NV");
        }
        if ((flags & FLAG_FORCE_NO_OPAQUE) != 0) {
            detectedFlagBits.add("VK_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCE_FLAG_FORCE_NO_OPAQUE_BIT_NV");
        }
        if ((flags & FLAG_FORCE_OPAQUE) != 0) {
            detectedFlagBits.add("VK_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCE_FLAG_FORCE_OPAQUE_BIT_NV");
        }
        if ((flags & FLAG_TRIANGLE_FACING_CULL_DISABLE) != 0) {
            detectedFlagBits.add("VK_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCE_FLAG_TRIANGLE_FACING_CULL_DISABLE_BIT_NV");
        }
        if ((flags & FLAG_TRIANGLE_FLIP_FACING) != 0) {
            detectedFlagBits.add("VK_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCE_FLAG_TRIANGLE_FLIP_FACING_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPartitionedAccelerationStructureInstanceFlagsNV() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureAddressResolutionFlagsNV.html"><code>VkClusterAccelerationStructureAddressResolutionFlagsNV</code></a>
public final class VkClusterAccelerationStructureAddressResolutionFlagsNV {
    public static final int INDIRECTED_DST_ADDRESS_ARRAY = 0x4;
    public static final int INDIRECTED_DST_IMPLICIT_DATA = 0x1;
    public static final int INDIRECTED_DST_SIZES_ARRAY = 0x8;
    public static final int INDIRECTED_SCRATCH_DATA = 0x2;
    public static final int INDIRECTED_SRC_INFOS_ARRAY = 0x10;
    public static final int INDIRECTED_SRC_INFOS_COUNT = 0x20;
    public static final int NONE = 0x0;

    public static String explain(@Bitmask(VkClusterAccelerationStructureAddressResolutionFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INDIRECTED_DST_ADDRESS_ARRAY) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_DST_ADDRESS_ARRAY_BIT_NV");
        }
        if ((flags & INDIRECTED_DST_IMPLICIT_DATA) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_DST_IMPLICIT_DATA_BIT_NV");
        }
        if ((flags & INDIRECTED_DST_SIZES_ARRAY) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_DST_SIZES_ARRAY_BIT_NV");
        }
        if ((flags & INDIRECTED_SCRATCH_DATA) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_SCRATCH_DATA_BIT_NV");
        }
        if ((flags & INDIRECTED_SRC_INFOS_ARRAY) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_SRC_INFOS_ARRAY_BIT_NV");
        }
        if ((flags & INDIRECTED_SRC_INFOS_COUNT) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_INDIRECTED_SRC_INFOS_COUNT_BIT_NV");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_ADDRESS_RESOLUTION_NONE_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkClusterAccelerationStructureAddressResolutionFlagsNV() {}
}

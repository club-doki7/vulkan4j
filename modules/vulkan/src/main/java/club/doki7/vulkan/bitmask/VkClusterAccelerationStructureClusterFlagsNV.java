package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureClusterFlagsNV.html"><code>VkClusterAccelerationStructureClusterFlagsNV</code></a>
public final class VkClusterAccelerationStructureClusterFlagsNV {
    public static final int ALLOW_DISABLE_OPACITY_MICROMAPS = 0x1;

    public static String explain(@Bitmask(VkClusterAccelerationStructureClusterFlagsNV.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_DISABLE_OPACITY_MICROMAPS) != 0) {
            detectedFlagBits.add("VK_CLUSTER_ACCELERATION_STRUCTURE_CLUSTER_ALLOW_DISABLE_OPACITY_MICROMAPS_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkClusterAccelerationStructureClusterFlagsNV() {}
}

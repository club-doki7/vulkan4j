package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildAccelerationStructureFlagsKHR.html"><code>VkBuildAccelerationStructureFlagsKHR</code></a>
public final class VkBuildAccelerationStructureFlagsKHR {
    public static final int ALLOW_CLUSTER_OPACITY_MICROMAPS_NV = 0x1000;
    public static final int ALLOW_COMPACTION = 0x2;
    public static final int ALLOW_DATA_ACCESS = 0x800;
    public static final int ALLOW_DISABLE_OPACITY_MICROMAPS = 0x80;
    public static final int ALLOW_DISPLACEMENT_MICROMAP_UPDATE_NV = 0x200;
    public static final int ALLOW_OPACITY_MICROMAP_DATA_UPDATE_EXT = 0x100;
    public static final int ALLOW_OPACITY_MICROMAP_UPDATE = 0x40;
    public static final int ALLOW_UPDATE = 0x1;
    public static final int LOW_MEMORY = 0x10;
    public static final int MICROMAP_LOSSY = 0x400;
    public static final int MOTION_NV = 0x20;
    public static final int PREFER_FAST_BUILD = 0x8;
    public static final int PREFER_FAST_TRACE = 0x4;

    public static String explain(@Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_CLUSTER_OPACITY_MICROMAPS_NV) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_CLUSTER_OPACITY_MICROMAPS_BIT_NV");
        }
        if ((flags & ALLOW_COMPACTION) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_COMPACTION_BIT_KHR");
        }
        if ((flags & ALLOW_DATA_ACCESS) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_DATA_ACCESS_BIT_KHR");
        }
        if ((flags & ALLOW_DISABLE_OPACITY_MICROMAPS) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_DISABLE_OPACITY_MICROMAPS_BIT_KHR");
        }
        if ((flags & ALLOW_DISPLACEMENT_MICROMAP_UPDATE_NV) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_DISPLACEMENT_MICROMAP_UPDATE_BIT_NV");
        }
        if ((flags & ALLOW_OPACITY_MICROMAP_DATA_UPDATE_EXT) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_OPACITY_MICROMAP_DATA_UPDATE_BIT_EXT");
        }
        if ((flags & ALLOW_OPACITY_MICROMAP_UPDATE) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_OPACITY_MICROMAP_UPDATE_BIT_KHR");
        }
        if ((flags & ALLOW_UPDATE) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_ALLOW_UPDATE_BIT_KHR");
        }
        if ((flags & LOW_MEMORY) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_LOW_MEMORY_BIT_KHR");
        }
        if ((flags & MICROMAP_LOSSY) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_MICROMAP_LOSSY_BIT_KHR");
        }
        if ((flags & MOTION_NV) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_MOTION_BIT_NV");
        }
        if ((flags & PREFER_FAST_BUILD) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_PREFER_FAST_BUILD_BIT_KHR");
        }
        if ((flags & PREFER_FAST_TRACE) != 0) {
            detectedFlagBits.add("VK_BUILD_ACCELERATION_STRUCTURE_PREFER_FAST_TRACE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBuildAccelerationStructureFlagsKHR() {}
}

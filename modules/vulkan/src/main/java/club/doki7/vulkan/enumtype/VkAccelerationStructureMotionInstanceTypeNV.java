package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureMotionInstanceTypeNV.html"><code>VkAccelerationStructureMotionInstanceTypeNV</code></a>
public final class VkAccelerationStructureMotionInstanceTypeNV {
    public static final int STATIC = 0x0;
    public static final int MATRIX_MOTION = 0x1;
    public static final int SRT_MOTION = 0x2;

    public static String explain(@EnumType(VkAccelerationStructureMotionInstanceTypeNV.class) int value) {
        return switch (value) {
            case VkAccelerationStructureMotionInstanceTypeNV.MATRIX_MOTION -> "VK_ACCELERATION_STRUCTURE_MOTION_INSTANCE_TYPE_MATRIX_MOTION_NV";
            case VkAccelerationStructureMotionInstanceTypeNV.SRT_MOTION -> "VK_ACCELERATION_STRUCTURE_MOTION_INSTANCE_TYPE_SRT_MOTION_NV";
            case VkAccelerationStructureMotionInstanceTypeNV.STATIC -> "VK_ACCELERATION_STRUCTURE_MOTION_INSTANCE_TYPE_STATIC_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccelerationStructureMotionInstanceTypeNV() {}
}

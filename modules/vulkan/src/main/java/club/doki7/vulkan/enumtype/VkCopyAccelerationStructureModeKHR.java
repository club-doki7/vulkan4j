package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyAccelerationStructureModeKHR.html"><code>VkCopyAccelerationStructureModeKHR</code></a>
public final class VkCopyAccelerationStructureModeKHR {
    public static final int CLONE = 0x0;
    public static final int COMPACT = 0x1;
    public static final int SERIALIZE = 0x2;
    public static final int DESERIALIZE = 0x3;

    public static String explain(@EnumType(VkCopyAccelerationStructureModeKHR.class) int value) {
        return switch (value) {
            case VkCopyAccelerationStructureModeKHR.CLONE -> "VK_COPY_ACCELERATION_STRUCTURE_MODE_CLONE_KHR";
            case VkCopyAccelerationStructureModeKHR.COMPACT -> "VK_COPY_ACCELERATION_STRUCTURE_MODE_COMPACT_KHR";
            case VkCopyAccelerationStructureModeKHR.DESERIALIZE -> "VK_COPY_ACCELERATION_STRUCTURE_MODE_DESERIALIZE_KHR";
            case VkCopyAccelerationStructureModeKHR.SERIALIZE -> "VK_COPY_ACCELERATION_STRUCTURE_MODE_SERIALIZE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCopyAccelerationStructureModeKHR() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureSerializedBlockTypeKHR.html"><code>VkAccelerationStructureSerializedBlockTypeKHR</code></a>
public final class VkAccelerationStructureSerializedBlockTypeKHR {
    public static final int OPACITY_MICROMAP = 0x0;

    public static String explain(@EnumType(VkAccelerationStructureSerializedBlockTypeKHR.class) int value) {
        return switch (value) {
            case VkAccelerationStructureSerializedBlockTypeKHR.OPACITY_MICROMAP -> "VK_ACCELERATION_STRUCTURE_SERIALIZED_BLOCK_TYPE_OPACITY_MICROMAP_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccelerationStructureSerializedBlockTypeKHR() {}
}

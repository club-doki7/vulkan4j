package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureTypeKHR.html"><code>VkAccelerationStructureTypeKHR</code></a>
public final class VkAccelerationStructureTypeKHR {
    public static final int TOP_LEVEL = 0x0;
    public static final int BOTTOM_LEVEL = 0x1;
    public static final int GENERIC = 0x2;
    public static final int OPACITY_MICROMAP = 0x3ba44b98;

    public static String explain(@EnumType(VkAccelerationStructureTypeKHR.class) int value) {
        return switch (value) {
            case VkAccelerationStructureTypeKHR.BOTTOM_LEVEL -> "VK_ACCELERATION_STRUCTURE_TYPE_BOTTOM_LEVEL_KHR";
            case VkAccelerationStructureTypeKHR.GENERIC -> "VK_ACCELERATION_STRUCTURE_TYPE_GENERIC_KHR";
            case VkAccelerationStructureTypeKHR.OPACITY_MICROMAP -> "VK_ACCELERATION_STRUCTURE_TYPE_OPACITY_MICROMAP_KHR";
            case VkAccelerationStructureTypeKHR.TOP_LEVEL -> "VK_ACCELERATION_STRUCTURE_TYPE_TOP_LEVEL_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccelerationStructureTypeKHR() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureCompatibilityKHR.html"><code>VkAccelerationStructureCompatibilityKHR</code></a>
public final class VkAccelerationStructureCompatibilityKHR {
    public static final int COMPATIBLE = 0x0;
    public static final int INCOMPATIBLE = 0x1;

    public static String explain(@EnumType(VkAccelerationStructureCompatibilityKHR.class) int value) {
        return switch (value) {
            case VkAccelerationStructureCompatibilityKHR.COMPATIBLE -> "VK_ACCELERATION_STRUCTURE_COMPATIBILITY_COMPATIBLE_KHR";
            case VkAccelerationStructureCompatibilityKHR.INCOMPATIBLE -> "VK_ACCELERATION_STRUCTURE_COMPATIBILITY_INCOMPATIBLE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccelerationStructureCompatibilityKHR() {}
}

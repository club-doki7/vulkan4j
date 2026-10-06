package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildAccelerationStructureModeKHR.html"><code>VkBuildAccelerationStructureModeKHR</code></a>
public final class VkBuildAccelerationStructureModeKHR {
    public static final int BUILD = 0x0;
    public static final int UPDATE = 0x1;

    public static String explain(@EnumType(VkBuildAccelerationStructureModeKHR.class) int value) {
        return switch (value) {
            case VkBuildAccelerationStructureModeKHR.BUILD -> "VK_BUILD_ACCELERATION_STRUCTURE_MODE_BUILD_KHR";
            case VkBuildAccelerationStructureModeKHR.UPDATE -> "VK_BUILD_ACCELERATION_STRUCTURE_MODE_UPDATE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBuildAccelerationStructureModeKHR() {}
}

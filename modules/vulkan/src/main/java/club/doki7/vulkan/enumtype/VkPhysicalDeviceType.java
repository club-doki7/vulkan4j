package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceType.html"><code>VkPhysicalDeviceType</code></a>
public final class VkPhysicalDeviceType {
    public static final int OTHER = 0x0;
    public static final int INTEGRATED_GPU = 0x1;
    public static final int DISCRETE_GPU = 0x2;
    public static final int VIRTUAL_GPU = 0x3;
    public static final int CPU = 0x4;

    public static String explain(@EnumType(VkPhysicalDeviceType.class) int value) {
        return switch (value) {
            case VkPhysicalDeviceType.CPU -> "VK_PHYSICAL_DEVICE_TYPE_CPU";
            case VkPhysicalDeviceType.DISCRETE_GPU -> "VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU";
            case VkPhysicalDeviceType.INTEGRATED_GPU -> "VK_PHYSICAL_DEVICE_TYPE_INTEGRATED_GPU";
            case VkPhysicalDeviceType.OTHER -> "VK_PHYSICAL_DEVICE_TYPE_OTHER";
            case VkPhysicalDeviceType.VIRTUAL_GPU -> "VK_PHYSICAL_DEVICE_TYPE_VIRTUAL_GPU";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPhysicalDeviceType() {}
}

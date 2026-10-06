package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultAddressTypeKHR.html"><code>VkDeviceFaultAddressTypeKHR</code></a>
public final class VkDeviceFaultAddressTypeKHR {
    public static final int NONE = 0x0;
    public static final int READ_INVALID = 0x1;
    public static final int WRITE_INVALID = 0x2;
    public static final int EXECUTE_INVALID = 0x3;
    public static final int INSTRUCTION_POINTER_UNKNOWN = 0x4;
    public static final int INSTRUCTION_POINTER_INVALID = 0x5;
    public static final int INSTRUCTION_POINTER_FAULT = 0x6;

    public static String explain(@EnumType(VkDeviceFaultAddressTypeKHR.class) int value) {
        return switch (value) {
            case VkDeviceFaultAddressTypeKHR.EXECUTE_INVALID -> "VK_DEVICE_FAULT_ADDRESS_TYPE_EXECUTE_INVALID_KHR";
            case VkDeviceFaultAddressTypeKHR.INSTRUCTION_POINTER_FAULT -> "VK_DEVICE_FAULT_ADDRESS_TYPE_INSTRUCTION_POINTER_FAULT_KHR";
            case VkDeviceFaultAddressTypeKHR.INSTRUCTION_POINTER_INVALID -> "VK_DEVICE_FAULT_ADDRESS_TYPE_INSTRUCTION_POINTER_INVALID_KHR";
            case VkDeviceFaultAddressTypeKHR.INSTRUCTION_POINTER_UNKNOWN -> "VK_DEVICE_FAULT_ADDRESS_TYPE_INSTRUCTION_POINTER_UNKNOWN_KHR";
            case VkDeviceFaultAddressTypeKHR.NONE -> "VK_DEVICE_FAULT_ADDRESS_TYPE_NONE_KHR";
            case VkDeviceFaultAddressTypeKHR.READ_INVALID -> "VK_DEVICE_FAULT_ADDRESS_TYPE_READ_INVALID_KHR";
            case VkDeviceFaultAddressTypeKHR.WRITE_INVALID -> "VK_DEVICE_FAULT_ADDRESS_TYPE_WRITE_INVALID_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceFaultAddressTypeKHR() {}
}

package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultVendorBinaryHeaderVersionKHR.html"><code>VkDeviceFaultVendorBinaryHeaderVersionKHR</code></a>
public final class VkDeviceFaultVendorBinaryHeaderVersionKHR {
    public static final int ONE = 0x1;

    public static String explain(@EnumType(VkDeviceFaultVendorBinaryHeaderVersionKHR.class) int value) {
        return switch (value) {
            case VkDeviceFaultVendorBinaryHeaderVersionKHR.ONE -> "VK_DEVICE_FAULT_VENDOR_BINARY_HEADER_VERSION_ONE_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceFaultVendorBinaryHeaderVersionKHR() {}
}

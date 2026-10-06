package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultFlagsKHR.html"><code>VkDeviceFaultFlagsKHR</code></a>
public final class VkDeviceFaultFlagsKHR {
    public static final int FLAG_DEVICE_LOST = 0x1;
    public static final int FLAG_INSTRUCTION_ADDRESS = 0x4;
    public static final int FLAG_MEMORY_ADDRESS = 0x2;
    public static final int FLAG_OVERFLOW = 0x20;
    public static final int FLAG_VENDOR = 0x8;
    public static final int FLAG_WATCHDOG_TIMEOUT = 0x10;

    public static String explain(@Bitmask(VkDeviceFaultFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FLAG_DEVICE_LOST) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_DEVICE_LOST_KHR");
        }
        if ((flags & FLAG_INSTRUCTION_ADDRESS) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_INSTRUCTION_ADDRESS_KHR");
        }
        if ((flags & FLAG_MEMORY_ADDRESS) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_MEMORY_ADDRESS_KHR");
        }
        if ((flags & FLAG_OVERFLOW) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_OVERFLOW_KHR");
        }
        if ((flags & FLAG_VENDOR) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_VENDOR_KHR");
        }
        if ((flags & FLAG_WATCHDOG_TIMEOUT) != 0) {
            detectedFlagBits.add("VK_DEVICE_FAULT_FLAG_WATCHDOG_TIMEOUT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceFaultFlagsKHR() {}
}

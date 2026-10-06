package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAddressCommandFlagsKHR.html"><code>VkAddressCommandFlagsKHR</code></a>
public final class VkAddressCommandFlagsKHR {
    public static final int FULLY_BOUND = 0x2;
    public static final int PROTECTED = 0x1;
    public static final int STORAGE_BUFFER_USAGE = 0x4;
    public static final int TRANSFORM_FEEDBACK_BUFFER_USAGE = 0x10;
    public static final int UNKNOWN_STORAGE_BUFFER_USAGE = 0x8;
    public static final int UNKNOWN_TRANSFORM_FEEDBACK_BUFFER_USAGE = 0x20;

    public static String explain(@Bitmask(VkAddressCommandFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FULLY_BOUND) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_FULLY_BOUND_BIT_KHR");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_PROTECTED_BIT_KHR");
        }
        if ((flags & STORAGE_BUFFER_USAGE) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_STORAGE_BUFFER_USAGE_BIT_KHR");
        }
        if ((flags & TRANSFORM_FEEDBACK_BUFFER_USAGE) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_TRANSFORM_FEEDBACK_BUFFER_USAGE_BIT_KHR");
        }
        if ((flags & UNKNOWN_STORAGE_BUFFER_USAGE) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_UNKNOWN_STORAGE_BUFFER_USAGE_BIT_KHR");
        }
        if ((flags & UNKNOWN_TRANSFORM_FEEDBACK_BUFFER_USAGE) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COMMAND_UNKNOWN_TRANSFORM_FEEDBACK_BUFFER_USAGE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAddressCommandFlagsKHR() {}
}

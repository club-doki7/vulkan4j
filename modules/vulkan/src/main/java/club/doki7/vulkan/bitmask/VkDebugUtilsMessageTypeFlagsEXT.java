package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessageTypeFlagsEXT.html"><code>VkDebugUtilsMessageTypeFlagsEXT</code></a>
public final class VkDebugUtilsMessageTypeFlagsEXT {
    public static final int DEVICE_ADDRESS_BINDING = 0x8;
    public static final int GENERAL = 0x1;
    public static final int PERFORMANCE = 0x4;
    public static final int VALIDATION = 0x2;

    public static String explain(@Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_ADDRESS_BINDING) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_TYPE_DEVICE_ADDRESS_BINDING_BIT_EXT");
        }
        if ((flags & GENERAL) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_TYPE_GENERAL_BIT_EXT");
        }
        if ((flags & PERFORMANCE) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_TYPE_PERFORMANCE_BIT_EXT");
        }
        if ((flags & VALIDATION) != 0) {
            detectedFlagBits.add("VK_DEBUG_UTILS_MESSAGE_TYPE_VALIDATION_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDebugUtilsMessageTypeFlagsEXT() {}
}

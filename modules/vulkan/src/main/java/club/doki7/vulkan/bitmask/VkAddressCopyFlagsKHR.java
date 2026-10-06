package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAddressCopyFlagsKHR.html"><code>VkAddressCopyFlagsKHR</code></a>
public final class VkAddressCopyFlagsKHR {
    public static final int DEVICE_LOCAL = 0x1;
    public static final int PROTECTED = 0x4;
    public static final int SPARSE = 0x2;

    public static String explain(@Bitmask(VkAddressCopyFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_LOCAL) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COPY_DEVICE_LOCAL_BIT_KHR");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COPY_PROTECTED_BIT_KHR");
        }
        if ((flags & SPARSE) != 0) {
            detectedFlagBits.add("VK_ADDRESS_COPY_SPARSE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAddressCopyFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPrivateDataSlotCreateFlags.html"><code>VkPrivateDataSlotCreateFlags</code></a>
public final class VkPrivateDataSlotCreateFlags {
    public static final int BASE_OBJECT_HANDLE_NV = 0x1;

    public static String explain(@Bitmask(VkPrivateDataSlotCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & BASE_OBJECT_HANDLE_NV) != 0) {
            detectedFlagBits.add("VK_PRIVATE_DATA_SLOT_CREATE_BASE_OBJECT_HANDLE_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPrivateDataSlotCreateFlags() {}
}

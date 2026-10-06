package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapCreateFlagsEXT.html"><code>VkMicromapCreateFlagsEXT</code></a>
public final class VkMicromapCreateFlagsEXT {
    public static final int DEVICE_ADDRESS_CAPTURE_REPLAY = 0x1;

    public static String explain(@Bitmask(VkMicromapCreateFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_ADDRESS_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_MICROMAP_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMicromapCreateFlagsEXT() {}
}

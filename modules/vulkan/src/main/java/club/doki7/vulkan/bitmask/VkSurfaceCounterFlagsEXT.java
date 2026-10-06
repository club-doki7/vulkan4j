package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCounterFlagsEXT.html"><code>VkSurfaceCounterFlagsEXT</code></a>
public final class VkSurfaceCounterFlagsEXT {
    public static final int VBLANK = 0x1;

    public static String explain(@Bitmask(VkSurfaceCounterFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & VBLANK) != 0) {
            detectedFlagBits.add("VK_SURFACE_COUNTER_VBLANK_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSurfaceCounterFlagsEXT() {}
}

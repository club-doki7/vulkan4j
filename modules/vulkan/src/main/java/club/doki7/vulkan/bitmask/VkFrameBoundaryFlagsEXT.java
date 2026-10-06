package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFrameBoundaryFlagsEXT.html"><code>VkFrameBoundaryFlagsEXT</code></a>
public final class VkFrameBoundaryFlagsEXT {
    public static final int FRAME_END = 0x1;

    public static String explain(@Bitmask(VkFrameBoundaryFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FRAME_END) != 0) {
            detectedFlagBits.add("VK_FRAME_BOUNDARY_FRAME_END_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkFrameBoundaryFlagsEXT() {}
}

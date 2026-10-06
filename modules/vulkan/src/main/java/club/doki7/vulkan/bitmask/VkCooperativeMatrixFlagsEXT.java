package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCooperativeMatrixFlagsEXT.html"><code>VkCooperativeMatrixFlagsEXT</code></a>
public final class VkCooperativeMatrixFlagsEXT {
    public static final int SATURATING_ACCUMULATION = 0x1;

    public static String explain(@Bitmask(VkCooperativeMatrixFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & SATURATING_ACCUMULATION) != 0) {
            detectedFlagBits.add("VK_COOPERATIVE_MATRIX_SATURATING_ACCUMULATION_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCooperativeMatrixFlagsEXT() {}
}

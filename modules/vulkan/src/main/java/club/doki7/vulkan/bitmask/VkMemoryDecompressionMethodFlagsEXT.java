package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryDecompressionMethodFlagsEXT.html"><code>VkMemoryDecompressionMethodFlagsEXT</code></a>
public final class VkMemoryDecompressionMethodFlagsEXT {
    public static final long GDEFLATE_1_0 = 0x1L;

    public static String explain(@Bitmask(VkMemoryDecompressionMethodFlagsEXT.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & GDEFLATE_1_0) != 0) {
            detectedFlagBits.add("VK_MEMORY_DECOMPRESSION_METHOD_GDEFLATE_1_0_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryDecompressionMethodFlagsEXT() {}
}

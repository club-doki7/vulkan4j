package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingFlags.html"><code>VkRenderingFlags</code></a>
public final class VkRenderingFlags {
    public static final int CONTENTS_INLINE_KHR = 0x10;
    public static final int CONTENTS_SECONDARY_COMMAND_BUFFERS = 0x1;
    public static final int CUSTOM_RESOLVE_EXT = 0x80;
    public static final int ENABLE_LEGACY_DITHERING_EXT = 0x8;
    public static final int FRAGMENT_REGION_EXT = 0x40;
    public static final int LOCAL_READ_CONCURRENT_ACCESS_CONTROL_KHR = 0x100;
    public static final int PER_LAYER_FRAGMENT_DENSITY_VALVE = 0x20;
    public static final int RESUMING = 0x4;
    public static final int SUSPENDING = 0x2;

    public static String explain(@Bitmask(VkRenderingFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CONTENTS_INLINE_KHR) != 0) {
            detectedFlagBits.add("VK_RENDERING_CONTENTS_INLINE_BIT_KHR");
        }
        if ((flags & CONTENTS_SECONDARY_COMMAND_BUFFERS) != 0) {
            detectedFlagBits.add("VK_RENDERING_CONTENTS_SECONDARY_COMMAND_BUFFERS_BIT");
        }
        if ((flags & CUSTOM_RESOLVE_EXT) != 0) {
            detectedFlagBits.add("VK_RENDERING_CUSTOM_RESOLVE_BIT_EXT");
        }
        if ((flags & ENABLE_LEGACY_DITHERING_EXT) != 0) {
            detectedFlagBits.add("VK_RENDERING_ENABLE_LEGACY_DITHERING_BIT_EXT");
        }
        if ((flags & FRAGMENT_REGION_EXT) != 0) {
            detectedFlagBits.add("VK_RENDERING_FRAGMENT_REGION_BIT_EXT");
        }
        if ((flags & LOCAL_READ_CONCURRENT_ACCESS_CONTROL_KHR) != 0) {
            detectedFlagBits.add("VK_RENDERING_LOCAL_READ_CONCURRENT_ACCESS_CONTROL_BIT_KHR");
        }
        if ((flags & PER_LAYER_FRAGMENT_DENSITY_VALVE) != 0) {
            detectedFlagBits.add("VK_RENDERING_PER_LAYER_FRAGMENT_DENSITY_BIT_VALVE");
        }
        if ((flags & RESUMING) != 0) {
            detectedFlagBits.add("VK_RENDERING_RESUMING_BIT");
        }
        if ((flags & SUSPENDING) != 0) {
            detectedFlagBits.add("VK_RENDERING_SUSPENDING_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkRenderingFlags() {}
}

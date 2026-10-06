package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneAlphaFlagsKHR.html"><code>VkDisplayPlaneAlphaFlagsKHR</code></a>
public final class VkDisplayPlaneAlphaFlagsKHR {
    public static final int GLOBAL = 0x2;
    public static final int OPAQUE = 0x1;
    public static final int PER_PIXEL = 0x4;
    public static final int PER_PIXEL_PREMULTIPLIED = 0x8;

    public static String explain(@Bitmask(VkDisplayPlaneAlphaFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & GLOBAL) != 0) {
            detectedFlagBits.add("VK_DISPLAY_PLANE_ALPHA_GLOBAL_BIT_KHR");
        }
        if ((flags & OPAQUE) != 0) {
            detectedFlagBits.add("VK_DISPLAY_PLANE_ALPHA_OPAQUE_BIT_KHR");
        }
        if ((flags & PER_PIXEL) != 0) {
            detectedFlagBits.add("VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_BIT_KHR");
        }
        if ((flags & PER_PIXEL_PREMULTIPLIED) != 0) {
            detectedFlagBits.add("VK_DISPLAY_PLANE_ALPHA_PER_PIXEL_PREMULTIPLIED_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDisplayPlaneAlphaFlagsKHR() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryFlagsKHR.html"><code>VkGeometryFlagsKHR</code></a>
public final class VkGeometryFlagsKHR {
    public static final int NO_DUPLICATE_ANY_HIT_INVOCATION = 0x2;
    public static final int OPAQUE = 0x1;

    public static String explain(@Bitmask(VkGeometryFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & NO_DUPLICATE_ANY_HIT_INVOCATION) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_NO_DUPLICATE_ANY_HIT_INVOCATION_BIT_KHR");
        }
        if ((flags & OPAQUE) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_OPAQUE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGeometryFlagsKHR() {}
}

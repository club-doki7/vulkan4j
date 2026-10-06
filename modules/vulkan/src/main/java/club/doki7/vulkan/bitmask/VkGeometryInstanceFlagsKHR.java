package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryInstanceFlagsKHR.html"><code>VkGeometryInstanceFlagsKHR</code></a>
public final class VkGeometryInstanceFlagsKHR {
    public static final int DISABLE_OPACITY_MICROMAPS = 0x20;
    public static final int FORCE_NO_OPAQUE = 0x8;
    public static final int FORCE_OPACITY_MICROMAP_2_STATE = 0x10;
    public static final int FORCE_OPAQUE = 0x4;
    public static final int TRIANGLE_FACING_CULL_DISABLE = 0x1;
    public static final int TRIANGLE_FLIP_FACING = 0x2;

    public static String explain(@Bitmask(VkGeometryInstanceFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DISABLE_OPACITY_MICROMAPS) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_DISABLE_OPACITY_MICROMAPS_BIT_KHR");
        }
        if ((flags & FORCE_NO_OPAQUE) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_FORCE_NO_OPAQUE_BIT_KHR");
        }
        if ((flags & FORCE_OPACITY_MICROMAP_2_STATE) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_FORCE_OPACITY_MICROMAP_2_STATE_BIT_KHR");
        }
        if ((flags & FORCE_OPAQUE) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_FORCE_OPAQUE_BIT_KHR");
        }
        if ((flags & TRIANGLE_FACING_CULL_DISABLE) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_TRIANGLE_FACING_CULL_DISABLE_BIT_KHR");
        }
        if ((flags & TRIANGLE_FLIP_FACING) != 0) {
            detectedFlagBits.add("VK_GEOMETRY_INSTANCE_TRIANGLE_FLIP_FACING_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGeometryInstanceFlagsKHR() {}
}

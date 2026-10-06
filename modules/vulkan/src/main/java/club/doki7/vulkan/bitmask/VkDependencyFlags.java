package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDependencyFlags.html"><code>VkDependencyFlags</code></a>
public final class VkDependencyFlags {
    public static final int ASYMMETRIC_EVENT_KHR = 0x40;
    public static final int BY_REGION = 0x1;
    public static final int DEVICE_GROUP = 0x4;
    public static final int FEEDBACK_LOOP_EXT = 0x8;
    public static final int QUEUE_FAMILY_OWNERSHIP_TRANSFER_USE_ALL_STAGES_KHR = 0x20;
    public static final int VIEW_LOCAL = 0x2;

    public static String explain(@Bitmask(VkDependencyFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ASYMMETRIC_EVENT_KHR) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_ASYMMETRIC_EVENT_BIT_KHR");
        }
        if ((flags & BY_REGION) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_BY_REGION_BIT");
        }
        if ((flags & DEVICE_GROUP) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_DEVICE_GROUP_BIT");
        }
        if ((flags & FEEDBACK_LOOP_EXT) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_FEEDBACK_LOOP_BIT_EXT");
        }
        if ((flags & QUEUE_FAMILY_OWNERSHIP_TRANSFER_USE_ALL_STAGES_KHR) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_QUEUE_FAMILY_OWNERSHIP_TRANSFER_USE_ALL_STAGES_BIT_KHR");
        }
        if ((flags & VIEW_LOCAL) != 0) {
            detectedFlagBits.add("VK_DEPENDENCY_VIEW_LOCAL_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDependencyFlags() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFlags.html"><code>VkQueueFlags</code></a>
public final class VkQueueFlags {
    public static final int COMPUTE = 0x2;
    public static final int DATA_GRAPH_ARM = 0x400;
    public static final int GRAPHICS = 0x1;
    public static final int OPTICAL_FLOW_NV = 0x100;
    public static final int PROTECTED = 0x10;
    public static final int SPARSE_BINDING = 0x8;
    public static final int TRANSFER = 0x4;
    public static final int VIDEO_DECODE_KHR = 0x20;
    public static final int VIDEO_ENCODE_KHR = 0x40;

    public static String explain(@Bitmask(VkQueueFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & COMPUTE) != 0) {
            detectedFlagBits.add("VK_QUEUE_COMPUTE_BIT");
        }
        if ((flags & DATA_GRAPH_ARM) != 0) {
            detectedFlagBits.add("VK_QUEUE_DATA_GRAPH_BIT_ARM");
        }
        if ((flags & GRAPHICS) != 0) {
            detectedFlagBits.add("VK_QUEUE_GRAPHICS_BIT");
        }
        if ((flags & OPTICAL_FLOW_NV) != 0) {
            detectedFlagBits.add("VK_QUEUE_OPTICAL_FLOW_BIT_NV");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_QUEUE_PROTECTED_BIT");
        }
        if ((flags & SPARSE_BINDING) != 0) {
            detectedFlagBits.add("VK_QUEUE_SPARSE_BINDING_BIT");
        }
        if ((flags & TRANSFER) != 0) {
            detectedFlagBits.add("VK_QUEUE_TRANSFER_BIT");
        }
        if ((flags & VIDEO_DECODE_KHR) != 0) {
            detectedFlagBits.add("VK_QUEUE_VIDEO_DECODE_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_KHR) != 0) {
            detectedFlagBits.add("VK_QUEUE_VIDEO_ENCODE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueueFlags() {}
}

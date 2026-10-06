package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentStageFlagsEXT.html"><code>VkPresentStageFlagsEXT</code></a>
public final class VkPresentStageFlagsEXT {
    public static final int IMAGE_FIRST_PIXEL_OUT = 0x4;
    public static final int IMAGE_FIRST_PIXEL_VISIBLE = 0x8;
    public static final int QUEUE_OPERATIONS_END = 0x1;
    public static final int REQUEST_DEQUEUED = 0x2;

    public static String explain(@Bitmask(VkPresentStageFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & IMAGE_FIRST_PIXEL_OUT) != 0) {
            detectedFlagBits.add("VK_PRESENT_STAGE_IMAGE_FIRST_PIXEL_OUT_BIT_EXT");
        }
        if ((flags & IMAGE_FIRST_PIXEL_VISIBLE) != 0) {
            detectedFlagBits.add("VK_PRESENT_STAGE_IMAGE_FIRST_PIXEL_VISIBLE_BIT_EXT");
        }
        if ((flags & QUEUE_OPERATIONS_END) != 0) {
            detectedFlagBits.add("VK_PRESENT_STAGE_QUEUE_OPERATIONS_END_BIT_EXT");
        }
        if ((flags & REQUEST_DEQUEUED) != 0) {
            detectedFlagBits.add("VK_PRESENT_STAGE_REQUEST_DEQUEUED_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPresentStageFlagsEXT() {}
}

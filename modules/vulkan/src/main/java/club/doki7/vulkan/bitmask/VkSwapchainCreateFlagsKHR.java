package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainCreateFlagsKHR.html"><code>VkSwapchainCreateFlagsKHR</code></a>
public final class VkSwapchainCreateFlagsKHR {
    public static final int DEFERRED_MEMORY_ALLOCATION = 0x8;
    public static final int MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT = 0x100;
    public static final int MUTABLE_FORMAT = 0x4;
    public static final int PRESENT_ID_2 = 0x40;
    public static final int PRESENT_TIMING_EXT = 0x200;
    public static final int PRESENT_WAIT_2 = 0x80;
    public static final int PROTECTED = 0x2;
    public static final int SPLIT_INSTANCE_BIND_REGIONS = 0x1;

    public static String explain(@Bitmask(VkSwapchainCreateFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEFERRED_MEMORY_ALLOCATION) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_DEFERRED_MEMORY_ALLOCATION_BIT_KHR");
        }
        if ((flags & MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_BIT_EXT");
        }
        if ((flags & MUTABLE_FORMAT) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_MUTABLE_FORMAT_BIT_KHR");
        }
        if ((flags & PRESENT_ID_2) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_PRESENT_ID_2_BIT_KHR");
        }
        if ((flags & PRESENT_TIMING_EXT) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_PRESENT_TIMING_BIT_EXT");
        }
        if ((flags & PRESENT_WAIT_2) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_PRESENT_WAIT_2_BIT_KHR");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_PROTECTED_BIT_KHR");
        }
        if ((flags & SPLIT_INSTANCE_BIND_REGIONS) != 0) {
            detectedFlagBits.add("VK_SWAPCHAIN_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSwapchainCreateFlagsKHR() {}
}

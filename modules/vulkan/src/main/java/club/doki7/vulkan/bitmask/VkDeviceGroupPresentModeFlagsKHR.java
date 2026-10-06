package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupPresentModeFlagsKHR.html"><code>VkDeviceGroupPresentModeFlagsKHR</code></a>
public final class VkDeviceGroupPresentModeFlagsKHR {
    public static final int LOCAL = 0x1;
    public static final int LOCAL_MULTI_DEVICE = 0x8;
    public static final int REMOTE = 0x2;
    public static final int SUM = 0x4;

    public static String explain(@Bitmask(VkDeviceGroupPresentModeFlagsKHR.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & LOCAL) != 0) {
            detectedFlagBits.add("VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_BIT_KHR");
        }
        if ((flags & LOCAL_MULTI_DEVICE) != 0) {
            detectedFlagBits.add("VK_DEVICE_GROUP_PRESENT_MODE_LOCAL_MULTI_DEVICE_BIT_KHR");
        }
        if ((flags & REMOTE) != 0) {
            detectedFlagBits.add("VK_DEVICE_GROUP_PRESENT_MODE_REMOTE_BIT_KHR");
        }
        if ((flags & SUM) != 0) {
            detectedFlagBits.add("VK_DEVICE_GROUP_PRESENT_MODE_SUM_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceGroupPresentModeFlagsKHR() {}
}

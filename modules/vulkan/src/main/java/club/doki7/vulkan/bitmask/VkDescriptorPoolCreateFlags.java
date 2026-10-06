package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorPoolCreateFlags.html"><code>VkDescriptorPoolCreateFlags</code></a>
public final class VkDescriptorPoolCreateFlags {
    public static final int ALLOW_OVERALLOCATION_POOLS_NV = 0x10;
    public static final int ALLOW_OVERALLOCATION_SETS_NV = 0x8;
    public static final int FREE_DESCRIPTOR_SET = 0x1;
    public static final int HOST_ONLY_EXT = 0x4;
    public static final int UPDATE_AFTER_BIND = 0x2;

    public static String explain(@Bitmask(VkDescriptorPoolCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ALLOW_OVERALLOCATION_POOLS_NV) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_POOL_CREATE_ALLOW_OVERALLOCATION_POOLS_BIT_NV");
        }
        if ((flags & ALLOW_OVERALLOCATION_SETS_NV) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_POOL_CREATE_ALLOW_OVERALLOCATION_SETS_BIT_NV");
        }
        if ((flags & FREE_DESCRIPTOR_SET) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_POOL_CREATE_FREE_DESCRIPTOR_SET_BIT");
        }
        if ((flags & HOST_ONLY_EXT) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_POOL_CREATE_HOST_ONLY_BIT_EXT");
        }
        if ((flags & UPDATE_AFTER_BIND) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDescriptorPoolCreateFlags() {}
}

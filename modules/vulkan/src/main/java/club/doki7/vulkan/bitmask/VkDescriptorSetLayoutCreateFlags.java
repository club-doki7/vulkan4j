package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutCreateFlags.html"><code>VkDescriptorSetLayoutCreateFlags</code></a>
public final class VkDescriptorSetLayoutCreateFlags {
    public static final int DESCRIPTOR_BUFFER_EXT = 0x10;
    public static final int EMBEDDED_IMMUTABLE_SAMPLERS_EXT = 0x20;
    public static final int HOST_ONLY_POOL_EXT = 0x4;
    public static final int INDIRECT_BINDABLE_NV = 0x80;
    public static final int PER_STAGE_NV = 0x40;
    public static final int PUSH_DESCRIPTOR = 0x1;
    public static final int UPDATE_AFTER_BIND_POOL = 0x2;

    public static String explain(@Bitmask(VkDescriptorSetLayoutCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & EMBEDDED_IMMUTABLE_SAMPLERS_EXT) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_EMBEDDED_IMMUTABLE_SAMPLERS_BIT_EXT");
        }
        if ((flags & HOST_ONLY_POOL_EXT) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_HOST_ONLY_POOL_BIT_EXT");
        }
        if ((flags & INDIRECT_BINDABLE_NV) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_INDIRECT_BINDABLE_BIT_NV");
        }
        if ((flags & PER_STAGE_NV) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_PER_STAGE_BIT_NV");
        }
        if ((flags & PUSH_DESCRIPTOR) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT");
        }
        if ((flags & UPDATE_AFTER_BIND_POOL) != 0) {
            detectedFlagBits.add("VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDescriptorSetLayoutCreateFlags() {}
}

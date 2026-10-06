package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryPropertyFlags.html"><code>VkMemoryPropertyFlags</code></a>
public final class VkMemoryPropertyFlags {
    public static final int DEVICE_COHERENT_AMD = 0x40;
    public static final int DEVICE_LOCAL = 0x1;
    public static final int DEVICE_UNCACHED_AMD = 0x80;
    public static final int HOST_CACHED = 0x8;
    public static final int HOST_COHERENT = 0x4;
    public static final int HOST_VISIBLE = 0x2;
    public static final int LAZILY_ALLOCATED = 0x10;
    public static final int PROTECTED = 0x20;
    public static final int RDMA_CAPABLE_NV = 0x100;

    public static String explain(@Bitmask(VkMemoryPropertyFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DEVICE_COHERENT_AMD) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD");
        }
        if ((flags & DEVICE_LOCAL) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT");
        }
        if ((flags & DEVICE_UNCACHED_AMD) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD");
        }
        if ((flags & HOST_CACHED) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_HOST_CACHED_BIT");
        }
        if ((flags & HOST_COHERENT) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_HOST_COHERENT_BIT");
        }
        if ((flags & HOST_VISIBLE) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT");
        }
        if ((flags & LAZILY_ALLOCATED) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_PROTECTED_BIT");
        }
        if ((flags & RDMA_CAPABLE_NV) != 0) {
            detectedFlagBits.add("VK_MEMORY_PROPERTY_RDMA_CAPABLE_BIT_NV");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryPropertyFlags() {}
}

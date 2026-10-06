package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCreateFlags.html"><code>VkBufferCreateFlags</code></a>
public final class VkBufferCreateFlags {
    public static final int DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT = 0x20;
    public static final int DEVICE_ADDRESS_CAPTURE_REPLAY = 0x10;
    public static final int PROTECTED = 0x8;
    public static final int SPARSE_ALIASED = 0x4;
    public static final int SPARSE_BINDING = 0x1;
    public static final int SPARSE_RESIDENCY = 0x2;
    public static final int VIDEO_PROFILE_INDEPENDENT_KHR = 0x40;

    public static String explain(@Bitmask(VkBufferCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_DESCRIPTOR_BUFFER_CAPTURE_REPLAY_BIT_EXT");
        }
        if ((flags & DEVICE_ADDRESS_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_PROTECTED_BIT");
        }
        if ((flags & SPARSE_ALIASED) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_SPARSE_ALIASED_BIT");
        }
        if ((flags & SPARSE_BINDING) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_SPARSE_BINDING_BIT");
        }
        if ((flags & SPARSE_RESIDENCY) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_SPARSE_RESIDENCY_BIT");
        }
        if ((flags & VIDEO_PROFILE_INDEPENDENT_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_CREATE_VIDEO_PROFILE_INDEPENDENT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBufferCreateFlags() {}
}

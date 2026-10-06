package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorCreateFlagsARM.html"><code>VkTensorCreateFlagsARM</code></a>
public final class VkTensorCreateFlagsARM {
    public static final long DESCRIPTOR_BUFFER_CAPTURE_REPLAY = 0x4L;
    public static final long DESCRIPTOR_HEAP_CAPTURE_REPLAY = 0x8L;
    public static final long MUTABLE_FORMAT = 0x1L;
    public static final long PROTECTED = 0x2L;

    public static String explain(@Bitmask(VkTensorCreateFlagsARM.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DESCRIPTOR_BUFFER_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_TENSOR_CREATE_DESCRIPTOR_BUFFER_CAPTURE_REPLAY_BIT_ARM");
        }
        if ((flags & DESCRIPTOR_HEAP_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_TENSOR_CREATE_DESCRIPTOR_HEAP_CAPTURE_REPLAY_BIT_ARM");
        }
        if ((flags & MUTABLE_FORMAT) != 0) {
            detectedFlagBits.add("VK_TENSOR_CREATE_MUTABLE_FORMAT_BIT_ARM");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_TENSOR_CREATE_PROTECTED_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTensorCreateFlagsARM() {}
}

package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorViewCreateFlagsARM.html"><code>VkTensorViewCreateFlagsARM</code></a>
public final class VkTensorViewCreateFlagsARM {
    public static final long DESCRIPTOR_BUFFER_CAPTURE_REPLAY = 0x1L;

    public static String explain(@Bitmask(VkTensorViewCreateFlagsARM.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DESCRIPTOR_BUFFER_CAPTURE_REPLAY) != 0) {
            detectedFlagBits.add("VK_TENSOR_VIEW_CREATE_DESCRIPTOR_BUFFER_CAPTURE_REPLAY_BIT_ARM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkTensorViewCreateFlagsARM() {}
}

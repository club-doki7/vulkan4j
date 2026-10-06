package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerCreateFlags.html"><code>VkSamplerCreateFlags</code></a>
public final class VkSamplerCreateFlags {
    public static final int DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT = 0x8;
    public static final int IMAGE_PROCESSING_QCOM = 0x10;
    public static final int NON_SEAMLESS_CUBE_MAP_EXT = 0x4;
    public static final int SUBSAMPLED_EXT = 0x1;
    public static final int SUBSAMPLED_COARSE_RECONSTRUCTION_EXT = 0x2;

    public static String explain(@Bitmask(VkSamplerCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT) != 0) {
            detectedFlagBits.add("VK_SAMPLER_CREATE_DESCRIPTOR_BUFFER_CAPTURE_REPLAY_BIT_EXT");
        }
        if ((flags & IMAGE_PROCESSING_QCOM) != 0) {
            detectedFlagBits.add("VK_SAMPLER_CREATE_IMAGE_PROCESSING_BIT_QCOM");
        }
        if ((flags & NON_SEAMLESS_CUBE_MAP_EXT) != 0) {
            detectedFlagBits.add("VK_SAMPLER_CREATE_NON_SEAMLESS_CUBE_MAP_BIT_EXT");
        }
        if ((flags & SUBSAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_SAMPLER_CREATE_SUBSAMPLED_BIT_EXT");
        }
        if ((flags & SUBSAMPLED_COARSE_RECONSTRUCTION_EXT) != 0) {
            detectedFlagBits.add("VK_SAMPLER_CREATE_SUBSAMPLED_COARSE_RECONSTRUCTION_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSamplerCreateFlags() {}
}

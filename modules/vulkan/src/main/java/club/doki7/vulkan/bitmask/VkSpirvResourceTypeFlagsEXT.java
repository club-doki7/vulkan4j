package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpirvResourceTypeFlagsEXT.html"><code>VkSpirvResourceTypeFlagsEXT</code></a>
public final class VkSpirvResourceTypeFlagsEXT {
    public static final int ACCELERATION_STRUCTURE = 0x100;
    public static final int ALL = 0x7fffffff;
    public static final int COMBINED_SAMPLED_IMAGE = 0x10;
    public static final int READ_ONLY_IMAGE = 0x4;
    public static final int READ_ONLY_STORAGE_BUFFER = 0x40;
    public static final int READ_WRITE_IMAGE = 0x8;
    public static final int READ_WRITE_STORAGE_BUFFER = 0x80;
    public static final int SAMPLED_IMAGE = 0x2;
    public static final int SAMPLER = 0x1;
    public static final int TENSOR_ARM = 0x200;
    public static final int UNIFORM_BUFFER = 0x20;

    public static String explain(@Bitmask(VkSpirvResourceTypeFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_ACCELERATION_STRUCTURE_BIT_EXT");
        }
        if ((flags & ALL) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_ALL_EXT");
        }
        if ((flags & COMBINED_SAMPLED_IMAGE) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_COMBINED_SAMPLED_IMAGE_BIT_EXT");
        }
        if ((flags & READ_ONLY_IMAGE) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_READ_ONLY_IMAGE_BIT_EXT");
        }
        if ((flags & READ_ONLY_STORAGE_BUFFER) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_READ_ONLY_STORAGE_BUFFER_BIT_EXT");
        }
        if ((flags & READ_WRITE_IMAGE) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_READ_WRITE_IMAGE_BIT_EXT");
        }
        if ((flags & READ_WRITE_STORAGE_BUFFER) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_READ_WRITE_STORAGE_BUFFER_BIT_EXT");
        }
        if ((flags & SAMPLED_IMAGE) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_SAMPLED_IMAGE_BIT_EXT");
        }
        if ((flags & SAMPLER) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_SAMPLER_BIT_EXT");
        }
        if ((flags & TENSOR_ARM) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_TENSOR_BIT_ARM");
        }
        if ((flags & UNIFORM_BUFFER) != 0) {
            detectedFlagBits.add("VK_SPIRV_RESOURCE_TYPE_UNIFORM_BUFFER_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSpirvResourceTypeFlagsEXT() {}
}

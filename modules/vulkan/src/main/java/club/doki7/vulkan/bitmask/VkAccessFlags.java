package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccessFlags.html"><code>VkAccessFlags</code></a>
public final class VkAccessFlags {
    public static final int ACCELERATION_STRUCTURE_READ_KHR = 0x200000;
    public static final int ACCELERATION_STRUCTURE_WRITE_KHR = 0x400000;
    public static final int COLOR_ATTACHMENT_READ = 0x80;
    public static final int COLOR_ATTACHMENT_READ_NONCOHERENT_EXT = 0x80000;
    public static final int COLOR_ATTACHMENT_WRITE = 0x100;
    public static final int COMMAND_PREPROCESS_READ_EXT = 0x20000;
    public static final int COMMAND_PREPROCESS_WRITE_EXT = 0x40000;
    public static final int CONDITIONAL_RENDERING_READ_EXT = 0x100000;
    public static final int DEPTH_STENCIL_ATTACHMENT_READ = 0x200;
    public static final int DEPTH_STENCIL_ATTACHMENT_WRITE = 0x400;
    public static final int FRAGMENT_DENSITY_MAP_READ_EXT = 0x1000000;
    public static final int FRAGMENT_SHADING_RATE_ATTACHMENT_READ_KHR = 0x800000;
    public static final int HOST_READ = 0x2000;
    public static final int HOST_WRITE = 0x4000;
    public static final int INDEX_READ = 0x2;
    public static final int INDIRECT_COMMAND_READ = 0x1;
    public static final int INPUT_ATTACHMENT_READ = 0x10;
    public static final int MEMORY_READ = 0x8000;
    public static final int MEMORY_WRITE = 0x10000;
    public static final int SHADER_READ = 0x20;
    public static final int SHADER_WRITE = 0x40;
    public static final int TRANSFER_READ = 0x800;
    public static final int TRANSFER_WRITE = 0x1000;
    public static final int TRANSFORM_FEEDBACK_COUNTER_READ_EXT = 0x4000000;
    public static final int TRANSFORM_FEEDBACK_COUNTER_WRITE_EXT = 0x8000000;
    public static final int TRANSFORM_FEEDBACK_WRITE_EXT = 0x2000000;
    public static final int UNIFORM_READ = 0x8;
    public static final int VERTEX_ATTRIBUTE_READ = 0x4;

    public static String explain(@Bitmask(VkAccessFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_ACCELERATION_STRUCTURE_READ_BIT_KHR");
        }
        if ((flags & ACCELERATION_STRUCTURE_WRITE_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_ACCELERATION_STRUCTURE_WRITE_BIT_KHR");
        }
        if ((flags & COLOR_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_COLOR_ATTACHMENT_READ_BIT");
        }
        if ((flags & COLOR_ATTACHMENT_READ_NONCOHERENT_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_COLOR_ATTACHMENT_READ_NONCOHERENT_BIT_EXT");
        }
        if ((flags & COLOR_ATTACHMENT_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT");
        }
        if ((flags & COMMAND_PREPROCESS_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_COMMAND_PREPROCESS_READ_BIT_EXT");
        }
        if ((flags & COMMAND_PREPROCESS_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_COMMAND_PREPROCESS_WRITE_BIT_EXT");
        }
        if ((flags & CONDITIONAL_RENDERING_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_CONDITIONAL_RENDERING_READ_BIT_EXT");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_FRAGMENT_DENSITY_MAP_READ_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_FRAGMENT_SHADING_RATE_ATTACHMENT_READ_BIT_KHR");
        }
        if ((flags & HOST_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_HOST_READ_BIT");
        }
        if ((flags & HOST_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_HOST_WRITE_BIT");
        }
        if ((flags & INDEX_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_INDEX_READ_BIT");
        }
        if ((flags & INDIRECT_COMMAND_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_INDIRECT_COMMAND_READ_BIT");
        }
        if ((flags & INPUT_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_INPUT_ATTACHMENT_READ_BIT");
        }
        if ((flags & MEMORY_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_MEMORY_READ_BIT");
        }
        if ((flags & MEMORY_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_MEMORY_WRITE_BIT");
        }
        if ((flags & SHADER_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_SHADER_READ_BIT");
        }
        if ((flags & SHADER_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_SHADER_WRITE_BIT");
        }
        if ((flags & TRANSFER_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_TRANSFER_READ_BIT");
        }
        if ((flags & TRANSFER_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_TRANSFER_WRITE_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_READ_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_WRITE_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_TRANSFORM_FEEDBACK_WRITE_BIT_EXT");
        }
        if ((flags & UNIFORM_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_UNIFORM_READ_BIT");
        }
        if ((flags & VERTEX_ATTRIBUTE_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_VERTEX_ATTRIBUTE_READ_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccessFlags() {}
}

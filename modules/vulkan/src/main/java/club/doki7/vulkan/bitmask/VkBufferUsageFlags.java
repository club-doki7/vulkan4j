package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferUsageFlags.html"><code>VkBufferUsageFlags</code></a>
public final class VkBufferUsageFlags {
    public static final int ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_KHR = 0x80000;
    public static final int ACCELERATION_STRUCTURE_STORAGE_KHR = 0x100000;
    public static final int CONDITIONAL_RENDERING_EXT = 0x200;
    public static final int DESCRIPTOR_HEAP_EXT = 0x10000000;
    public static final int EXECUTION_GRAPH_SCRATCH_AMDX = 0x2000000;
    public static final int INDEX_BUFFER = 0x40;
    public static final int INDIRECT_BUFFER = 0x100;
    public static final int MICROMAP_BUILD_INPUT_READ_ONLY_EXT = 0x800000;
    public static final int MICROMAP_STORAGE_EXT = 0x1000000;
    public static final int PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_EXT = 0x4000000;
    public static final int RESOURCE_DESCRIPTOR_BUFFER_EXT = 0x400000;
    public static final int SAMPLER_DESCRIPTOR_BUFFER_EXT = 0x200000;
    public static final int SHADER_BINDING_TABLE_KHR = 0x400;
    public static final int SHADER_DEVICE_ADDRESS = 0x20000;
    public static final int STORAGE_BUFFER = 0x20;
    public static final int STORAGE_TEXEL_BUFFER = 0x8;
    public static final int TILE_MEMORY_QCOM = 0x8000000;
    public static final int TRANSFER_DST = 0x2;
    public static final int TRANSFER_SRC = 0x1;
    public static final int TRANSFORM_FEEDBACK_BUFFER_EXT = 0x800;
    public static final int TRANSFORM_FEEDBACK_COUNTER_BUFFER_EXT = 0x1000;
    public static final int UNIFORM_BUFFER = 0x10;
    public static final int UNIFORM_TEXEL_BUFFER = 0x4;
    public static final int VERTEX_BUFFER = 0x80;
    public static final int VIDEO_DECODE_DST_KHR = 0x4000;
    public static final int VIDEO_DECODE_SRC_KHR = 0x2000;
    public static final int VIDEO_ENCODE_DST_KHR = 0x8000;
    public static final int VIDEO_ENCODE_SRC_KHR = 0x10000;

    public static String explain(@Bitmask(VkBufferUsageFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_BIT_KHR");
        }
        if ((flags & ACCELERATION_STRUCTURE_STORAGE_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_ACCELERATION_STRUCTURE_STORAGE_BIT_KHR");
        }
        if ((flags & CONDITIONAL_RENDERING_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_CONDITIONAL_RENDERING_BIT_EXT");
        }
        if ((flags & DESCRIPTOR_HEAP_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_DESCRIPTOR_HEAP_BIT_EXT");
        }
        if ((flags & EXECUTION_GRAPH_SCRATCH_AMDX) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_EXECUTION_GRAPH_SCRATCH_BIT_AMDX");
        }
        if ((flags & INDEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_INDEX_BUFFER_BIT");
        }
        if ((flags & INDIRECT_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_INDIRECT_BUFFER_BIT");
        }
        if ((flags & MICROMAP_BUILD_INPUT_READ_ONLY_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_MICROMAP_BUILD_INPUT_READ_ONLY_BIT_EXT");
        }
        if ((flags & MICROMAP_STORAGE_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_MICROMAP_STORAGE_BIT_EXT");
        }
        if ((flags & PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & RESOURCE_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_RESOURCE_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & SAMPLER_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_SAMPLER_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & SHADER_BINDING_TABLE_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_SHADER_BINDING_TABLE_BIT_KHR");
        }
        if ((flags & SHADER_DEVICE_ADDRESS) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_SHADER_DEVICE_ADDRESS_BIT");
        }
        if ((flags & STORAGE_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_STORAGE_BUFFER_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_STORAGE_TEXEL_BUFFER_BIT");
        }
        if ((flags & TILE_MEMORY_QCOM) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_TILE_MEMORY_BIT_QCOM");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_TRANSFER_DST_BIT");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_TRANSFER_SRC_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_TRANSFORM_FEEDBACK_BUFFER_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_TRANSFORM_FEEDBACK_COUNTER_BUFFER_BIT_EXT");
        }
        if ((flags & UNIFORM_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT");
        }
        if ((flags & UNIFORM_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_UNIFORM_TEXEL_BUFFER_BIT");
        }
        if ((flags & VERTEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_VERTEX_BUFFER_BIT");
        }
        if ((flags & VIDEO_DECODE_DST_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_VIDEO_DECODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_SRC_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_VIDEO_DECODE_SRC_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DST_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_VIDEO_ENCODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_SRC_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_VIDEO_ENCODE_SRC_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBufferUsageFlags() {}
}

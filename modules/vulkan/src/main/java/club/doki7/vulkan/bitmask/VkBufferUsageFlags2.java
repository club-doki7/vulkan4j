package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferUsageFlags2.html"><code>VkBufferUsageFlags2</code></a>
public final class VkBufferUsageFlags2 {
    public static final long ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_KHR = 0x80000L;
    public static final long ACCELERATION_STRUCTURE_STORAGE_KHR = 0x100000L;
    public static final long COMPRESSED_DATA_DGF1_AMDX = 0x200000000L;
    public static final long CONDITIONAL_RENDERING_EXT = 0x200L;
    public static final long DATA_GRAPH_FOREIGN_DESCRIPTOR_ARM = 0x20000000L;
    public static final long DESCRIPTOR_HEAP_EXT = 0x10000000L;
    public static final long EXECUTION_GRAPH_SCRATCH_AMDX = 0x2000000L;
    public static final long INDEX_BUFFER = 0x40L;
    public static final long INDIRECT_BUFFER = 0x100L;
    public static final long MEMORY_DECOMPRESSION_EXT = 0x100000000L;
    public static final long MICROMAP_BUILD_INPUT_READ_ONLY_EXT = 0x800000L;
    public static final long MICROMAP_STORAGE_EXT = 0x1000000L;
    public static final long PREPROCESS_BUFFER_EXT = 0x80000000L;
    public static final long PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_EXT = 0x4000000L;
    public static final long RESOURCE_DESCRIPTOR_BUFFER_EXT = 0x400000L;
    public static final long SAMPLER_DESCRIPTOR_BUFFER_EXT = 0x200000L;
    public static final long SHADER_BINDING_TABLE_KHR = 0x400L;
    public static final long SHADER_DEVICE_ADDRESS = 0x20000L;
    public static final long STORAGE_BUFFER = 0x20L;
    public static final long STORAGE_TEXEL_BUFFER = 0x8L;
    public static final long TILE_MEMORY_QCOM = 0x8000000L;
    public static final long TRANSFER_DST = 0x2L;
    public static final long TRANSFER_SRC = 0x1L;
    public static final long TRANSFORM_FEEDBACK_BUFFER_EXT = 0x800L;
    public static final long TRANSFORM_FEEDBACK_COUNTER_BUFFER_EXT = 0x1000L;
    public static final long UNIFORM_BUFFER = 0x10L;
    public static final long UNIFORM_TEXEL_BUFFER = 0x4L;
    public static final long VERTEX_BUFFER = 0x80L;
    public static final long VIDEO_DECODE_DST_KHR = 0x4000L;
    public static final long VIDEO_DECODE_SRC_KHR = 0x2000L;
    public static final long VIDEO_ENCODE_DST_KHR = 0x8000L;
    public static final long VIDEO_ENCODE_SRC_KHR = 0x10000L;

    public static String explain(@Bitmask(VkBufferUsageFlags2.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_BIT_KHR");
        }
        if ((flags & ACCELERATION_STRUCTURE_STORAGE_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_ACCELERATION_STRUCTURE_STORAGE_BIT_KHR");
        }
        if ((flags & COMPRESSED_DATA_DGF1_AMDX) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_COMPRESSED_DATA_DGF1_BIT_AMDX");
        }
        if ((flags & CONDITIONAL_RENDERING_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_CONDITIONAL_RENDERING_BIT_EXT");
        }
        if ((flags & DATA_GRAPH_FOREIGN_DESCRIPTOR_ARM) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_DATA_GRAPH_FOREIGN_DESCRIPTOR_BIT_ARM");
        }
        if ((flags & DESCRIPTOR_HEAP_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_DESCRIPTOR_HEAP_BIT_EXT");
        }
        if ((flags & EXECUTION_GRAPH_SCRATCH_AMDX) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_EXECUTION_GRAPH_SCRATCH_BIT_AMDX");
        }
        if ((flags & INDEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_INDEX_BUFFER_BIT");
        }
        if ((flags & INDIRECT_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_INDIRECT_BUFFER_BIT");
        }
        if ((flags & MEMORY_DECOMPRESSION_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_MEMORY_DECOMPRESSION_BIT_EXT");
        }
        if ((flags & MICROMAP_BUILD_INPUT_READ_ONLY_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_MICROMAP_BUILD_INPUT_READ_ONLY_BIT_EXT");
        }
        if ((flags & MICROMAP_STORAGE_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_MICROMAP_STORAGE_BIT_EXT");
        }
        if ((flags & PREPROCESS_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_PREPROCESS_BUFFER_BIT_EXT");
        }
        if ((flags & PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & RESOURCE_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_RESOURCE_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & SAMPLER_DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_SAMPLER_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & SHADER_BINDING_TABLE_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_SHADER_BINDING_TABLE_BIT_KHR");
        }
        if ((flags & SHADER_DEVICE_ADDRESS) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_SHADER_DEVICE_ADDRESS_BIT");
        }
        if ((flags & STORAGE_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_STORAGE_BUFFER_BIT");
        }
        if ((flags & STORAGE_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_STORAGE_TEXEL_BUFFER_BIT");
        }
        if ((flags & TILE_MEMORY_QCOM) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_TILE_MEMORY_BIT_QCOM");
        }
        if ((flags & TRANSFER_DST) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_TRANSFER_DST_BIT");
        }
        if ((flags & TRANSFER_SRC) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_TRANSFER_SRC_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_TRANSFORM_FEEDBACK_BUFFER_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_TRANSFORM_FEEDBACK_COUNTER_BUFFER_BIT_EXT");
        }
        if ((flags & UNIFORM_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_UNIFORM_BUFFER_BIT");
        }
        if ((flags & UNIFORM_TEXEL_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_UNIFORM_TEXEL_BUFFER_BIT");
        }
        if ((flags & VERTEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_VERTEX_BUFFER_BIT");
        }
        if ((flags & VIDEO_DECODE_DST_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_VIDEO_DECODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_SRC_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_VIDEO_DECODE_SRC_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_DST_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_VIDEO_ENCODE_DST_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_SRC_KHR) != 0) {
            detectedFlagBits.add("VK_BUFFER_USAGE_2_VIDEO_ENCODE_SRC_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkBufferUsageFlags2() {}
}

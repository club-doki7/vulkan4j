package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccessFlags2.html"><code>VkAccessFlags2</code></a>
public final class VkAccessFlags2 {
    public static final long ACCELERATION_STRUCTURE_READ_KHR = 0x200000L;
    public static final long ACCELERATION_STRUCTURE_WRITE_KHR = 0x400000L;
    public static final long COLOR_ATTACHMENT_READ = 0x80L;
    public static final long COLOR_ATTACHMENT_READ_NONCOHERENT_EXT = 0x80000L;
    public static final long COLOR_ATTACHMENT_WRITE = 0x100L;
    public static final long COMMAND_PREPROCESS_READ_EXT = 0x20000L;
    public static final long COMMAND_PREPROCESS_WRITE_EXT = 0x40000L;
    public static final long CONDITIONAL_RENDERING_READ_EXT = 0x100000L;
    public static final long DATA_GRAPH_READ_ARM = 0x800000000000L;
    public static final long DATA_GRAPH_WRITE_ARM = 0x1000000000000L;
    public static final long DEPTH_STENCIL_ATTACHMENT_READ = 0x200L;
    public static final long DEPTH_STENCIL_ATTACHMENT_WRITE = 0x400L;
    public static final long DESCRIPTOR_BUFFER_READ_EXT = 0x20000000000L;
    public static final long FRAGMENT_DENSITY_MAP_READ_EXT = 0x1000000L;
    public static final long FRAGMENT_SHADING_RATE_ATTACHMENT_READ_KHR = 0x800000L;
    public static final long HOST_READ = 0x2000L;
    public static final long HOST_WRITE = 0x4000L;
    public static final long INDEX_READ = 0x2L;
    public static final long INDIRECT_COMMAND_READ = 0x1L;
    public static final long INPUT_ATTACHMENT_READ = 0x10L;
    public static final long INVOCATION_MASK_READ_HUAWEI = 0x8000000000L;
    public static final long MEMORY_DECOMPRESSION_READ_EXT = 0x80000000000000L;
    public static final long MEMORY_DECOMPRESSION_WRITE_EXT = 0x100000000000000L;
    public static final long MEMORY_READ = 0x8000L;
    public static final long MEMORY_WRITE = 0x10000L;
    public static final long MICROMAP_READ_EXT = 0x100000000000L;
    public static final long MICROMAP_WRITE_EXT = 0x200000000000L;
    public static final long NONE = 0x0L;
    public static final long OPTICAL_FLOW_READ_NV = 0x40000000000L;
    public static final long OPTICAL_FLOW_WRITE_NV = 0x80000000000L;
    public static final long RESOURCE_HEAP_READ_EXT = 0x400000000000000L;
    public static final long SAMPLER_HEAP_READ_EXT = 0x200000000000000L;
    public static final long SHADER_BINDING_TABLE_READ_KHR = 0x10000000000L;
    public static final long SHADER_READ = 0x20L;
    public static final long SHADER_SAMPLED_READ = 0x100000000L;
    public static final long SHADER_STORAGE_READ = 0x200000000L;
    public static final long SHADER_STORAGE_WRITE = 0x400000000L;
    public static final long SHADER_TILE_ATTACHMENT_READ_QCOM = 0x8000000000000L;
    public static final long SHADER_TILE_ATTACHMENT_WRITE_QCOM = 0x10000000000000L;
    public static final long SHADER_WRITE = 0x40L;
    public static final long TRANSFER_READ = 0x800L;
    public static final long TRANSFER_WRITE = 0x1000L;
    public static final long TRANSFORM_FEEDBACK_COUNTER_READ_EXT = 0x4000000L;
    public static final long TRANSFORM_FEEDBACK_COUNTER_WRITE_EXT = 0x8000000L;
    public static final long TRANSFORM_FEEDBACK_WRITE_EXT = 0x2000000L;
    public static final long UNIFORM_READ = 0x8L;
    public static final long VERTEX_ATTRIBUTE_READ = 0x4L;
    public static final long VIDEO_DECODE_READ_KHR = 0x800000000L;
    public static final long VIDEO_DECODE_WRITE_KHR = 0x1000000000L;
    public static final long VIDEO_ENCODE_READ_KHR = 0x2000000000L;
    public static final long VIDEO_ENCODE_WRITE_KHR = 0x4000000000L;

    public static String explain(@Bitmask(VkAccessFlags2.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_ACCELERATION_STRUCTURE_READ_BIT_KHR");
        }
        if ((flags & ACCELERATION_STRUCTURE_WRITE_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_ACCELERATION_STRUCTURE_WRITE_BIT_KHR");
        }
        if ((flags & COLOR_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_COLOR_ATTACHMENT_READ_BIT");
        }
        if ((flags & COLOR_ATTACHMENT_READ_NONCOHERENT_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_COLOR_ATTACHMENT_READ_NONCOHERENT_BIT_EXT");
        }
        if ((flags & COLOR_ATTACHMENT_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_COLOR_ATTACHMENT_WRITE_BIT");
        }
        if ((flags & COMMAND_PREPROCESS_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_COMMAND_PREPROCESS_READ_BIT_EXT");
        }
        if ((flags & COMMAND_PREPROCESS_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_COMMAND_PREPROCESS_WRITE_BIT_EXT");
        }
        if ((flags & CONDITIONAL_RENDERING_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_CONDITIONAL_RENDERING_READ_BIT_EXT");
        }
        if ((flags & DATA_GRAPH_READ_ARM) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_DATA_GRAPH_READ_BIT_ARM");
        }
        if ((flags & DATA_GRAPH_WRITE_ARM) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_DATA_GRAPH_WRITE_BIT_ARM");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_DEPTH_STENCIL_ATTACHMENT_READ_BIT");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT");
        }
        if ((flags & DESCRIPTOR_BUFFER_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_DESCRIPTOR_BUFFER_READ_BIT_EXT");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_FRAGMENT_DENSITY_MAP_READ_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_FRAGMENT_SHADING_RATE_ATTACHMENT_READ_BIT_KHR");
        }
        if ((flags & HOST_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_HOST_READ_BIT");
        }
        if ((flags & HOST_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_HOST_WRITE_BIT");
        }
        if ((flags & INDEX_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_INDEX_READ_BIT");
        }
        if ((flags & INDIRECT_COMMAND_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_INDIRECT_COMMAND_READ_BIT");
        }
        if ((flags & INPUT_ATTACHMENT_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_INPUT_ATTACHMENT_READ_BIT");
        }
        if ((flags & INVOCATION_MASK_READ_HUAWEI) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_INVOCATION_MASK_READ_BIT_HUAWEI");
        }
        if ((flags & MEMORY_DECOMPRESSION_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MEMORY_DECOMPRESSION_READ_BIT_EXT");
        }
        if ((flags & MEMORY_DECOMPRESSION_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MEMORY_DECOMPRESSION_WRITE_BIT_EXT");
        }
        if ((flags & MEMORY_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MEMORY_READ_BIT");
        }
        if ((flags & MEMORY_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MEMORY_WRITE_BIT");
        }
        if ((flags & MICROMAP_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MICROMAP_READ_BIT_EXT");
        }
        if ((flags & MICROMAP_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_MICROMAP_WRITE_BIT_EXT");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_NONE");
        }
        if ((flags & OPTICAL_FLOW_READ_NV) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_OPTICAL_FLOW_READ_BIT_NV");
        }
        if ((flags & OPTICAL_FLOW_WRITE_NV) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_OPTICAL_FLOW_WRITE_BIT_NV");
        }
        if ((flags & RESOURCE_HEAP_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_RESOURCE_HEAP_READ_BIT_EXT");
        }
        if ((flags & SAMPLER_HEAP_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SAMPLER_HEAP_READ_BIT_EXT");
        }
        if ((flags & SHADER_BINDING_TABLE_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_BINDING_TABLE_READ_BIT_KHR");
        }
        if ((flags & SHADER_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_READ_BIT");
        }
        if ((flags & SHADER_SAMPLED_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_SAMPLED_READ_BIT");
        }
        if ((flags & SHADER_STORAGE_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_STORAGE_READ_BIT");
        }
        if ((flags & SHADER_STORAGE_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_STORAGE_WRITE_BIT");
        }
        if ((flags & SHADER_TILE_ATTACHMENT_READ_QCOM) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_TILE_ATTACHMENT_READ_BIT_QCOM");
        }
        if ((flags & SHADER_TILE_ATTACHMENT_WRITE_QCOM) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_TILE_ATTACHMENT_WRITE_BIT_QCOM");
        }
        if ((flags & SHADER_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_SHADER_WRITE_BIT");
        }
        if ((flags & TRANSFER_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_TRANSFER_READ_BIT");
        }
        if ((flags & TRANSFER_WRITE) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_TRANSFER_WRITE_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_READ_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_TRANSFORM_FEEDBACK_COUNTER_READ_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_COUNTER_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_TRANSFORM_FEEDBACK_COUNTER_WRITE_BIT_EXT");
        }
        if ((flags & TRANSFORM_FEEDBACK_WRITE_EXT) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_TRANSFORM_FEEDBACK_WRITE_BIT_EXT");
        }
        if ((flags & UNIFORM_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_UNIFORM_READ_BIT");
        }
        if ((flags & VERTEX_ATTRIBUTE_READ) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_VERTEX_ATTRIBUTE_READ_BIT");
        }
        if ((flags & VIDEO_DECODE_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_VIDEO_DECODE_READ_BIT_KHR");
        }
        if ((flags & VIDEO_DECODE_WRITE_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_VIDEO_DECODE_WRITE_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_READ_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_VIDEO_ENCODE_READ_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_WRITE_KHR) != 0) {
            detectedFlagBits.add("VK_ACCESS_2_VIDEO_ENCODE_WRITE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAccessFlags2() {}
}

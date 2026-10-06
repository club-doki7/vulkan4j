package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineStageFlags2.html"><code>VkPipelineStageFlags2</code></a>
public final class VkPipelineStageFlags2 {
    public static final long ACCELERATION_STRUCTURE_BUILD_KHR = 0x2000000L;
    public static final long ACCELERATION_STRUCTURE_COPY_KHR = 0x10000000L;
    public static final long ALL_COMMANDS = 0x10000L;
    public static final long ALL_GRAPHICS = 0x8000L;
    public static final long ALL_TRANSFER = 0x1000L;
    public static final long BLIT = 0x400000000L;
    public static final long BOTTOM_OF_PIPE = 0x2000L;
    public static final long CLEAR = 0x800000000L;
    public static final long CLUSTER_CULLING_SHADER_HUAWEI = 0x20000000000L;
    public static final long COLOR_ATTACHMENT_OUTPUT = 0x400L;
    public static final long COMMAND_PREPROCESS_EXT = 0x20000L;
    public static final long COMPUTE_SHADER = 0x800L;
    public static final long CONDITIONAL_RENDERING_EXT = 0x40000L;
    public static final long CONVERT_COOPERATIVE_VECTOR_MATRIX_NV = 0x100000000000L;
    public static final long COPY = 0x100000000L;
    public static final long COPY_INDIRECT_KHR = 0x400000000000L;
    public static final long DATA_GRAPH_ARM = 0x40000000000L;
    public static final long DRAW_INDIRECT = 0x2L;
    public static final long EARLY_FRAGMENT_TESTS = 0x100L;
    public static final long FRAGMENT_DENSITY_PROCESS_EXT = 0x800000L;
    public static final long FRAGMENT_SHADER = 0x80L;
    public static final long FRAGMENT_SHADING_RATE_ATTACHMENT_KHR = 0x400000L;
    public static final long GEOMETRY_SHADER = 0x40L;
    public static final long HOST = 0x4000L;
    public static final long INDEX_INPUT = 0x1000000000L;
    public static final long INVOCATION_MASK_HUAWEI = 0x10000000000L;
    public static final long LATE_FRAGMENT_TESTS = 0x200L;
    public static final long MEMORY_DECOMPRESSION_EXT = 0x200000000000L;
    public static final long MESH_SHADER_EXT = 0x100000L;
    public static final long MICROMAP_BUILD_EXT = 0x40000000L;
    public static final long NONE = 0x0L;
    public static final long OPTICAL_FLOW_NV = 0x20000000L;
    public static final long PRE_RASTERIZATION_SHADERS = 0x4000000000L;
    public static final long RAY_TRACING_SHADER_KHR = 0x200000L;
    public static final long RESOLVE = 0x200000000L;
    public static final long SUBPASS_SHADER_HUAWEI = 0x8000000000L;
    public static final long TASK_SHADER_EXT = 0x80000L;
    public static final long TESSELLATION_CONTROL_SHADER = 0x10L;
    public static final long TESSELLATION_EVALUATION_SHADER = 0x20L;
    public static final long TOP_OF_PIPE = 0x1L;
    public static final long TRANSFORM_FEEDBACK_EXT = 0x1000000L;
    public static final long VERTEX_ATTRIBUTE_INPUT = 0x2000000000L;
    public static final long VERTEX_INPUT = 0x4L;
    public static final long VERTEX_SHADER = 0x8L;
    public static final long VIDEO_DECODE_KHR = 0x4000000L;
    public static final long VIDEO_ENCODE_KHR = 0x8000000L;

    public static String explain(@Bitmask(VkPipelineStageFlags2.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_BUILD_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_ACCELERATION_STRUCTURE_BUILD_BIT_KHR");
        }
        if ((flags & ACCELERATION_STRUCTURE_COPY_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_ACCELERATION_STRUCTURE_COPY_BIT_KHR");
        }
        if ((flags & ALL_COMMANDS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_ALL_COMMANDS_BIT");
        }
        if ((flags & ALL_GRAPHICS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_ALL_GRAPHICS_BIT");
        }
        if ((flags & ALL_TRANSFER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_ALL_TRANSFER_BIT");
        }
        if ((flags & BLIT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_BLIT_BIT");
        }
        if ((flags & BOTTOM_OF_PIPE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_BOTTOM_OF_PIPE_BIT");
        }
        if ((flags & CLEAR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_CLEAR_BIT");
        }
        if ((flags & CLUSTER_CULLING_SHADER_HUAWEI) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_CLUSTER_CULLING_SHADER_BIT_HUAWEI");
        }
        if ((flags & COLOR_ATTACHMENT_OUTPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_COLOR_ATTACHMENT_OUTPUT_BIT");
        }
        if ((flags & COMMAND_PREPROCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_COMMAND_PREPROCESS_BIT_EXT");
        }
        if ((flags & COMPUTE_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_COMPUTE_SHADER_BIT");
        }
        if ((flags & CONDITIONAL_RENDERING_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_CONDITIONAL_RENDERING_BIT_EXT");
        }
        if ((flags & CONVERT_COOPERATIVE_VECTOR_MATRIX_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_CONVERT_COOPERATIVE_VECTOR_MATRIX_BIT_NV");
        }
        if ((flags & COPY) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_COPY_BIT");
        }
        if ((flags & COPY_INDIRECT_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_COPY_INDIRECT_BIT_KHR");
        }
        if ((flags & DATA_GRAPH_ARM) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_DATA_GRAPH_BIT_ARM");
        }
        if ((flags & DRAW_INDIRECT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_DRAW_INDIRECT_BIT");
        }
        if ((flags & EARLY_FRAGMENT_TESTS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_EARLY_FRAGMENT_TESTS_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_PROCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_FRAGMENT_DENSITY_PROCESS_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_FRAGMENT_SHADER_BIT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & GEOMETRY_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_GEOMETRY_SHADER_BIT");
        }
        if ((flags & HOST) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_HOST_BIT");
        }
        if ((flags & INDEX_INPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_INDEX_INPUT_BIT");
        }
        if ((flags & INVOCATION_MASK_HUAWEI) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_INVOCATION_MASK_BIT_HUAWEI");
        }
        if ((flags & LATE_FRAGMENT_TESTS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_LATE_FRAGMENT_TESTS_BIT");
        }
        if ((flags & MEMORY_DECOMPRESSION_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_MEMORY_DECOMPRESSION_BIT_EXT");
        }
        if ((flags & MESH_SHADER_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_MESH_SHADER_BIT_EXT");
        }
        if ((flags & MICROMAP_BUILD_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_MICROMAP_BUILD_BIT_EXT");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_NONE");
        }
        if ((flags & OPTICAL_FLOW_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_OPTICAL_FLOW_BIT_NV");
        }
        if ((flags & PRE_RASTERIZATION_SHADERS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_PRE_RASTERIZATION_SHADERS_BIT");
        }
        if ((flags & RAY_TRACING_SHADER_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_RAY_TRACING_SHADER_BIT_KHR");
        }
        if ((flags & RESOLVE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_RESOLVE_BIT");
        }
        if ((flags & SUBPASS_SHADER_HUAWEI) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_SUBPASS_SHADER_BIT_HUAWEI");
        }
        if ((flags & TASK_SHADER_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_TASK_SHADER_BIT_EXT");
        }
        if ((flags & TESSELLATION_CONTROL_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_TESSELLATION_CONTROL_SHADER_BIT");
        }
        if ((flags & TESSELLATION_EVALUATION_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_TESSELLATION_EVALUATION_SHADER_BIT");
        }
        if ((flags & TOP_OF_PIPE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_TOP_OF_PIPE_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_TRANSFORM_FEEDBACK_BIT_EXT");
        }
        if ((flags & VERTEX_ATTRIBUTE_INPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_VERTEX_ATTRIBUTE_INPUT_BIT");
        }
        if ((flags & VERTEX_INPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_VERTEX_INPUT_BIT");
        }
        if ((flags & VERTEX_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_VERTEX_SHADER_BIT");
        }
        if ((flags & VIDEO_DECODE_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_VIDEO_DECODE_BIT_KHR");
        }
        if ((flags & VIDEO_ENCODE_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_2_VIDEO_ENCODE_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineStageFlags2() {}
}

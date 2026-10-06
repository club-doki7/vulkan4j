package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineStageFlags.html"><code>VkPipelineStageFlags</code></a>
public final class VkPipelineStageFlags {
    public static final int ACCELERATION_STRUCTURE_BUILD_KHR = 0x2000000;
    public static final int ALL_COMMANDS = 0x10000;
    public static final int ALL_GRAPHICS = 0x8000;
    public static final int BOTTOM_OF_PIPE = 0x2000;
    public static final int COLOR_ATTACHMENT_OUTPUT = 0x400;
    public static final int COMMAND_PREPROCESS_EXT = 0x20000;
    public static final int COMPUTE_SHADER = 0x800;
    public static final int CONDITIONAL_RENDERING_EXT = 0x40000;
    public static final int DRAW_INDIRECT = 0x2;
    public static final int EARLY_FRAGMENT_TESTS = 0x100;
    public static final int FRAGMENT_DENSITY_PROCESS_EXT = 0x800000;
    public static final int FRAGMENT_SHADER = 0x80;
    public static final int FRAGMENT_SHADING_RATE_ATTACHMENT_KHR = 0x400000;
    public static final int GEOMETRY_SHADER = 0x40;
    public static final int HOST = 0x4000;
    public static final int LATE_FRAGMENT_TESTS = 0x200;
    public static final int MESH_SHADER_EXT = 0x100000;
    public static final int RAY_TRACING_SHADER_KHR = 0x200000;
    public static final int TASK_SHADER_EXT = 0x80000;
    public static final int TESSELLATION_CONTROL_SHADER = 0x10;
    public static final int TESSELLATION_EVALUATION_SHADER = 0x20;
    public static final int TOP_OF_PIPE = 0x1;
    public static final int TRANSFER = 0x1000;
    public static final int TRANSFORM_FEEDBACK_EXT = 0x1000000;
    public static final int VERTEX_INPUT = 0x4;
    public static final int VERTEX_SHADER = 0x8;

    public static String explain(@Bitmask(VkPipelineStageFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ACCELERATION_STRUCTURE_BUILD_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_ACCELERATION_STRUCTURE_BUILD_BIT_KHR");
        }
        if ((flags & ALL_COMMANDS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_ALL_COMMANDS_BIT");
        }
        if ((flags & ALL_GRAPHICS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_ALL_GRAPHICS_BIT");
        }
        if ((flags & BOTTOM_OF_PIPE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_BOTTOM_OF_PIPE_BIT");
        }
        if ((flags & COLOR_ATTACHMENT_OUTPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT");
        }
        if ((flags & COMMAND_PREPROCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_COMMAND_PREPROCESS_BIT_EXT");
        }
        if ((flags & COMPUTE_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT");
        }
        if ((flags & CONDITIONAL_RENDERING_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_CONDITIONAL_RENDERING_BIT_EXT");
        }
        if ((flags & DRAW_INDIRECT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_DRAW_INDIRECT_BIT");
        }
        if ((flags & EARLY_FRAGMENT_TESTS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_PROCESS_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_FRAGMENT_DENSITY_PROCESS_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT");
        }
        if ((flags & FRAGMENT_SHADING_RATE_ATTACHMENT_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & GEOMETRY_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_GEOMETRY_SHADER_BIT");
        }
        if ((flags & HOST) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_HOST_BIT");
        }
        if ((flags & LATE_FRAGMENT_TESTS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_LATE_FRAGMENT_TESTS_BIT");
        }
        if ((flags & MESH_SHADER_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_MESH_SHADER_BIT_EXT");
        }
        if ((flags & RAY_TRACING_SHADER_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_RAY_TRACING_SHADER_BIT_KHR");
        }
        if ((flags & TASK_SHADER_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TASK_SHADER_BIT_EXT");
        }
        if ((flags & TESSELLATION_CONTROL_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TESSELLATION_CONTROL_SHADER_BIT");
        }
        if ((flags & TESSELLATION_EVALUATION_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TESSELLATION_EVALUATION_SHADER_BIT");
        }
        if ((flags & TOP_OF_PIPE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT");
        }
        if ((flags & TRANSFER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TRANSFER_BIT");
        }
        if ((flags & TRANSFORM_FEEDBACK_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_TRANSFORM_FEEDBACK_BIT_EXT");
        }
        if ((flags & VERTEX_INPUT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_VERTEX_INPUT_BIT");
        }
        if ((flags & VERTEX_SHADER) != 0) {
            detectedFlagBits.add("VK_PIPELINE_STAGE_VERTEX_SHADER_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineStageFlags() {}
}

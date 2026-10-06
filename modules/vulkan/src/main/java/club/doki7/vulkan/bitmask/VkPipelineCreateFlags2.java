package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCreateFlags2.html"><code>VkPipelineCreateFlags2</code></a>
public final class VkPipelineCreateFlags2 {
    public static final long _64_BIT_INDEXING_EXT = 0x80000000000L;
    public static final long ALLOW_DERIVATIVES = 0x2L;
    public static final long CAPTURE_DATA_KHR = 0x80000000L;
    public static final long CAPTURE_INTERNAL_REPRESENTATIONS_KHR = 0x80L;
    public static final long CAPTURE_STATISTICS_KHR = 0x40L;
    public static final long COLOR_ATTACHMENT_FEEDBACK_LOOP_EXT = 0x2000000L;
    public static final long DEFER_COMPILE_NV = 0x20L;
    public static final long DEPTH_STENCIL_ATTACHMENT_FEEDBACK_LOOP_EXT = 0x4000000L;
    public static final long DERIVATIVE = 0x4L;
    public static final long DESCRIPTOR_BUFFER_EXT = 0x20000000L;
    public static final long DESCRIPTOR_HEAP_EXT = 0x1000000000L;
    public static final long DISABLE_OPTIMIZATION = 0x1L;
    public static final long DISALLOW_OPACITY_MICROMAP_ARM = 0x2000000000L;
    public static final long DISPATCH_BASE = 0x10L;
    public static final long EARLY_RETURN_ON_FAILURE = 0x200L;
    public static final long ENABLE_LEGACY_DITHERING_EXT = 0x400000000L;
    public static final long EXECUTION_GRAPH_AMDX = 0x100000000L;
    public static final long FAIL_ON_PIPELINE_COMPILE_REQUIRED = 0x100L;
    public static final long INDIRECT_BINDABLE_EXT = 0x4000000000L;
    public static final long INDIRECT_BINDABLE_NV = 0x40000L;
    public static final long INSTRUMENT_SHADERS_ARM = 0x8000000000L;
    public static final long LIBRARY_KHR = 0x800L;
    public static final long LINK_TIME_OPTIMIZATION_EXT = 0x400L;
    public static final long NO_PROTECTED_ACCESS = 0x8000000L;
    public static final long OPACITY_MICROMAP_DISALLOW_MIXED_SPECIAL_INDEX_KHR = 0x20000000000L;
    public static final long PER_LAYER_FRAGMENT_DENSITY_VALVE = 0x10000000000L;
    public static final long PROTECTED_ACCESS_ONLY = 0x40000000L;
    public static final long RAY_TRACING_ALLOW_MOTION_NV = 0x100000L;
    public static final long RAY_TRACING_ALLOW_SPHERES_AND_LINEAR_SWEPT_SPHERES_NV = 0x200000000L;
    public static final long RAY_TRACING_DISPLACEMENT_MICROMAP_NV = 0x10000000L;
    public static final long RAY_TRACING_NO_NULL_ANY_HIT_SHADERS_KHR = 0x4000L;
    public static final long RAY_TRACING_NO_NULL_CLOSEST_HIT_SHADERS_KHR = 0x8000L;
    public static final long RAY_TRACING_NO_NULL_INTERSECTION_SHADERS_KHR = 0x20000L;
    public static final long RAY_TRACING_NO_NULL_MISS_SHADERS_KHR = 0x10000L;
    public static final long RAY_TRACING_OPACITY_MICROMAP_KHR = 0x1000000L;
    public static final long RAY_TRACING_SHADER_GROUP_HANDLE_CAPTURE_REPLAY_KHR = 0x80000L;
    public static final long RAY_TRACING_SKIP_AABBS_KHR = 0x2000L;
    public static final long RAY_TRACING_SKIP_TRIANGLES_KHR = 0x1000L;
    public static final long RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_EXT = 0x400000L;
    public static final long RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_KHR = 0x200000L;
    public static final long RETAIN_LINK_TIME_OPTIMIZATION_INFO_EXT = 0x800000L;
    public static final long VIEW_INDEX_FROM_DEVICE_INDEX = 0x8L;

    public static String explain(@Bitmask(VkPipelineCreateFlags2.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _64_BIT_INDEXING_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_64_BIT_INDEXING_BIT_EXT");
        }
        if ((flags & ALLOW_DERIVATIVES) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_ALLOW_DERIVATIVES_BIT");
        }
        if ((flags & CAPTURE_DATA_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_CAPTURE_DATA_BIT_KHR");
        }
        if ((flags & CAPTURE_INTERNAL_REPRESENTATIONS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_CAPTURE_INTERNAL_REPRESENTATIONS_BIT_KHR");
        }
        if ((flags & CAPTURE_STATISTICS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_CAPTURE_STATISTICS_BIT_KHR");
        }
        if ((flags & COLOR_ATTACHMENT_FEEDBACK_LOOP_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_COLOR_ATTACHMENT_FEEDBACK_LOOP_BIT_EXT");
        }
        if ((flags & DEFER_COMPILE_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DEFER_COMPILE_BIT_NV");
        }
        if ((flags & DEPTH_STENCIL_ATTACHMENT_FEEDBACK_LOOP_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DEPTH_STENCIL_ATTACHMENT_FEEDBACK_LOOP_BIT_EXT");
        }
        if ((flags & DERIVATIVE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DERIVATIVE_BIT");
        }
        if ((flags & DESCRIPTOR_BUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DESCRIPTOR_BUFFER_BIT_EXT");
        }
        if ((flags & DESCRIPTOR_HEAP_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DESCRIPTOR_HEAP_BIT_EXT");
        }
        if ((flags & DISABLE_OPTIMIZATION) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DISABLE_OPTIMIZATION_BIT");
        }
        if ((flags & DISALLOW_OPACITY_MICROMAP_ARM) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DISALLOW_OPACITY_MICROMAP_BIT_ARM");
        }
        if ((flags & DISPATCH_BASE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_DISPATCH_BASE_BIT");
        }
        if ((flags & EARLY_RETURN_ON_FAILURE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_EARLY_RETURN_ON_FAILURE_BIT");
        }
        if ((flags & ENABLE_LEGACY_DITHERING_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_ENABLE_LEGACY_DITHERING_BIT_EXT");
        }
        if ((flags & EXECUTION_GRAPH_AMDX) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_EXECUTION_GRAPH_BIT_AMDX");
        }
        if ((flags & FAIL_ON_PIPELINE_COMPILE_REQUIRED) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_FAIL_ON_PIPELINE_COMPILE_REQUIRED_BIT");
        }
        if ((flags & INDIRECT_BINDABLE_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_INDIRECT_BINDABLE_BIT_EXT");
        }
        if ((flags & INDIRECT_BINDABLE_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_INDIRECT_BINDABLE_BIT_NV");
        }
        if ((flags & INSTRUMENT_SHADERS_ARM) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_INSTRUMENT_SHADERS_BIT_ARM");
        }
        if ((flags & LIBRARY_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_LIBRARY_BIT_KHR");
        }
        if ((flags & LINK_TIME_OPTIMIZATION_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_LINK_TIME_OPTIMIZATION_BIT_EXT");
        }
        if ((flags & NO_PROTECTED_ACCESS) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_NO_PROTECTED_ACCESS_BIT");
        }
        if ((flags & OPACITY_MICROMAP_DISALLOW_MIXED_SPECIAL_INDEX_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_OPACITY_MICROMAP_DISALLOW_MIXED_SPECIAL_INDEX_BIT_KHR");
        }
        if ((flags & PER_LAYER_FRAGMENT_DENSITY_VALVE) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_PER_LAYER_FRAGMENT_DENSITY_BIT_VALVE");
        }
        if ((flags & PROTECTED_ACCESS_ONLY) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_PROTECTED_ACCESS_ONLY_BIT");
        }
        if ((flags & RAY_TRACING_ALLOW_MOTION_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_ALLOW_MOTION_BIT_NV");
        }
        if ((flags & RAY_TRACING_ALLOW_SPHERES_AND_LINEAR_SWEPT_SPHERES_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_ALLOW_SPHERES_AND_LINEAR_SWEPT_SPHERES_BIT_NV");
        }
        if ((flags & RAY_TRACING_DISPLACEMENT_MICROMAP_NV) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_DISPLACEMENT_MICROMAP_BIT_NV");
        }
        if ((flags & RAY_TRACING_NO_NULL_ANY_HIT_SHADERS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_ANY_HIT_SHADERS_BIT_KHR");
        }
        if ((flags & RAY_TRACING_NO_NULL_CLOSEST_HIT_SHADERS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_CLOSEST_HIT_SHADERS_BIT_KHR");
        }
        if ((flags & RAY_TRACING_NO_NULL_INTERSECTION_SHADERS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_INTERSECTION_SHADERS_BIT_KHR");
        }
        if ((flags & RAY_TRACING_NO_NULL_MISS_SHADERS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_MISS_SHADERS_BIT_KHR");
        }
        if ((flags & RAY_TRACING_OPACITY_MICROMAP_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_OPACITY_MICROMAP_BIT_KHR");
        }
        if ((flags & RAY_TRACING_SHADER_GROUP_HANDLE_CAPTURE_REPLAY_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_SHADER_GROUP_HANDLE_CAPTURE_REPLAY_BIT_KHR");
        }
        if ((flags & RAY_TRACING_SKIP_AABBS_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_SKIP_AABBS_BIT_KHR");
        }
        if ((flags & RAY_TRACING_SKIP_TRIANGLES_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RAY_TRACING_SKIP_TRIANGLES_BIT_KHR");
        }
        if ((flags & RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_BIT_EXT");
        }
        if ((flags & RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_KHR) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR");
        }
        if ((flags & RETAIN_LINK_TIME_OPTIMIZATION_INFO_EXT) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_RETAIN_LINK_TIME_OPTIMIZATION_INFO_BIT_EXT");
        }
        if ((flags & VIEW_INDEX_FROM_DEVICE_INDEX) != 0) {
            detectedFlagBits.add("VK_PIPELINE_CREATE_2_VIEW_INDEX_FROM_DEVICE_INDEX_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkPipelineCreateFlags2() {}
}

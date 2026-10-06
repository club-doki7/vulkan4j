package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryType.html"><code>VkQueryType</code></a>
public final class VkQueryType {
    public static final int OCCLUSION = 0x0;
    public static final int PIPELINE_STATISTICS = 0x1;
    public static final int TIMESTAMP = 0x2;
    public static final int RESULT_STATUS_ONLY_KHR = 0x3b9b23d8;
    public static final int TRANSFORM_FEEDBACK_STREAM_EXT = 0x3b9b3764;
    public static final int PERFORMANCE_QUERY_KHR = 0x3b9c8f20;
    public static final int ACCELERATION_STRUCTURE_COMPACTED_SIZE_KHR = 0x3b9d13f0;
    public static final int ACCELERATION_STRUCTURE_SERIALIZATION_SIZE_KHR = 0x3b9d13f1;
    public static final int ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV = 0x3b9d4e88;
    public static final int TIME_ELAPSED_QCOM = 0x3b9d6dc8;
    public static final int PERFORMANCE_QUERY_INTEL = 0x3b9dfe50;
    public static final int VIDEO_ENCODE_FEEDBACK_KHR = 0x3b9f59f8;
    public static final int MESH_PRIMITIVES_GENERATED_EXT = 0x3b9fcb40;
    public static final int PRIMITIVES_GENERATED_EXT = 0x3ba09e30;
    public static final int ACCELERATION_STRUCTURE_SERIALIZATION_BOTTOM_LEVEL_POINTERS_KHR = 0x3ba0add0;
    public static final int ACCELERATION_STRUCTURE_SIZE_KHR = 0x3ba0add1;
    public static final int MICROMAP_SERIALIZATION_SIZE_EXT = 0x3ba0d4e0;
    public static final int MICROMAP_COMPACTED_SIZE_EXT = 0x3ba0d4e1;

    public static String explain(@EnumType(VkQueryType.class) int value) {
        return switch (value) {
            case VkQueryType.ACCELERATION_STRUCTURE_COMPACTED_SIZE_KHR -> "VK_QUERY_TYPE_ACCELERATION_STRUCTURE_COMPACTED_SIZE_KHR";
            case VkQueryType.ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV -> "VK_QUERY_TYPE_ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV";
            case VkQueryType.ACCELERATION_STRUCTURE_SERIALIZATION_BOTTOM_LEVEL_POINTERS_KHR -> "VK_QUERY_TYPE_ACCELERATION_STRUCTURE_SERIALIZATION_BOTTOM_LEVEL_POINTERS_KHR";
            case VkQueryType.ACCELERATION_STRUCTURE_SERIALIZATION_SIZE_KHR -> "VK_QUERY_TYPE_ACCELERATION_STRUCTURE_SERIALIZATION_SIZE_KHR";
            case VkQueryType.ACCELERATION_STRUCTURE_SIZE_KHR -> "VK_QUERY_TYPE_ACCELERATION_STRUCTURE_SIZE_KHR";
            case VkQueryType.MESH_PRIMITIVES_GENERATED_EXT -> "VK_QUERY_TYPE_MESH_PRIMITIVES_GENERATED_EXT";
            case VkQueryType.MICROMAP_COMPACTED_SIZE_EXT -> "VK_QUERY_TYPE_MICROMAP_COMPACTED_SIZE_EXT";
            case VkQueryType.MICROMAP_SERIALIZATION_SIZE_EXT -> "VK_QUERY_TYPE_MICROMAP_SERIALIZATION_SIZE_EXT";
            case VkQueryType.OCCLUSION -> "VK_QUERY_TYPE_OCCLUSION";
            case VkQueryType.PERFORMANCE_QUERY_INTEL -> "VK_QUERY_TYPE_PERFORMANCE_QUERY_INTEL";
            case VkQueryType.PERFORMANCE_QUERY_KHR -> "VK_QUERY_TYPE_PERFORMANCE_QUERY_KHR";
            case VkQueryType.PIPELINE_STATISTICS -> "VK_QUERY_TYPE_PIPELINE_STATISTICS";
            case VkQueryType.PRIMITIVES_GENERATED_EXT -> "VK_QUERY_TYPE_PRIMITIVES_GENERATED_EXT";
            case VkQueryType.RESULT_STATUS_ONLY_KHR -> "VK_QUERY_TYPE_RESULT_STATUS_ONLY_KHR";
            case VkQueryType.TIMESTAMP -> "VK_QUERY_TYPE_TIMESTAMP";
            case VkQueryType.TIME_ELAPSED_QCOM -> "VK_QUERY_TYPE_TIME_ELAPSED_QCOM";
            case VkQueryType.TRANSFORM_FEEDBACK_STREAM_EXT -> "VK_QUERY_TYPE_TRANSFORM_FEEDBACK_STREAM_EXT";
            case VkQueryType.VIDEO_ENCODE_FEEDBACK_KHR -> "VK_QUERY_TYPE_VIDEO_ENCODE_FEEDBACK_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkQueryType() {}
}
